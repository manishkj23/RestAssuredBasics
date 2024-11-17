package DgxApiRestAssuredBasic.Electrolux;

import ApiPayloads.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ElectroluxDGXAPI {

    String nextQuestionID, claimState, answerType, answerID, newClaimID,questionID1,
            answerID1, statusCode, ServiceOptionId;
    String questionID = "";
    String PlanNo = "C1Z9063567"; //3BA9041146 - A
    String modelNumber = "EWG14";
    String productType="WASHING MACHINE";
    String channelCode = "DGX";
    String env="domgenprelive";
    String oem="Electrolux";

    @Test
    void claimCreationWithAppointmentBookedForElectroluxOem()
    {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://www.skylinecms.co.uk/")
                .setContentType(ContentType.JSON)
                .addHeader("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .build();
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";

//************************************ Cancel an open claim ****************************************************************//

        //Get An Open Claim if exist and then cancel it:

        String getOpenClaimResponse  = given().queryParam("t","GetAllClaims").queryParam("PolicyNumber",PlanNo)
                .queryParam("ChannelCode","ORB").queryParam("CountryCode","GB")
                .header("Content-Type", "application/json")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .when().get("/domgenprelive/RestAPI/ClaimsAPI/")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js0 = new JsonPath(getOpenClaimResponse);
        String openClaimNumber = js0.getString("Response.PolicyData."+PlanNo+".ClaimNumber");
        String openClaimStatus = js0.getString("Response.PolicyData."+PlanNo+".RepairHistory[0].RepairStatusHistory[0].Status");
        System.out.println("Open Claim No. is : " + openClaimNumber);
        System.out.println("Open Claim No. Status is : " + openClaimStatus);

        //Cancel An Open Claim:
        if(openClaimNumber != null && openClaimStatus != "Repair request cancelled")
        {
            CancelAnOpenClaim.cancelOpenClaim(openClaimNumber,PlanNo,env);
        } else {
            System.out.println("No Open Claim present for the Plan number : " + PlanNo);
        }

//************************************ StartTransaction API: ****************************************************************//

        //StartTransactionAPI
        String response = given().queryParam("m","StartTransaction")
                .header("Content-Type","application/json")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(startTransactionAPI.createNewGuid(PlanNo,productType,channelCode,oem))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        //to extract the value we have to store them in variable and to do that we have to type String = variableName before given()
        JsonPath js = new JsonPath(response); // to parse JSON response
        String guid = js.getString("GUID");
        String StatusCode = js.getString("StatusCode");
        if(StatusCode.equalsIgnoreCase("ST000") || StatusCode.equalsIgnoreCase("ST001")) {
            System.out.println("GUID from StartTransactionAPI :" + guid);
        }
        else
        {
            System.out.println("GUID not created successfully and StartTransaction API got failed");
        }

//************************************ GetMandatoryData API: ****************************************************************//

        String getMandatoryDataResponse = given().queryParam("m", "GetMandatoryData")
                .header("Content-Type","application/json")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(getMandatoryDataAPI.getMandatoryDataAPI(guid,channelCode))
                .when().log().all().get("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode",equalTo("GM000"))
                .extract().response().asString();
        JsonPath js1 = new JsonPath(getMandatoryDataResponse);
        String GMUniqueApplianceIDValue  = js1.getString("UniqueApplianceID");
        String GMModelNumberValue  = js1.getString("ModelNumber");
        String GMFaultCategoryID = js1.getString("FaultData[0].FaultCategoryID");
        String GMFaultID = js1.getString("FaultData[0].PossibleAnswers[0].FaultID");
        String ClaimTypeValue = js1.getString("ClaimTypes[0].ClaimTypeID");
        System.out.println("Unique Appliance ID is : "  + GMUniqueApplianceIDValue);
        System.out.println("Model Number is : "  + GMModelNumberValue);
        System.out.println("Fault Category ID is : "  + GMFaultCategoryID);
        System.out.println("Fault ID is : "  + GMFaultID);
        System.out.println("Claim Type value is : "  + ClaimTypeValue);

//****************************************************************************************************//

        /*UseGetData to get the Model No. and UpdateTransaction API to update the Model Number in case
        UniqueApplianceID is NULL in GetMandatoryData API */

        //UseGetData API:
        if(GMUniqueApplianceIDValue == null) {
            String getDataModelResponse = given().queryParam("m", "GetData")
                    .header("Content-Type", "application/json")
                    .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .body(useGetDataAPI.useGetDataByModel(guid,modelNumber))
                    .when().log().all().get("/"+env+"/RestAPI/BookClaim/")
                    .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("GD000"))
                    .extract().response().asString();
            JsonPath js2 = new JsonPath(getDataModelResponse);
            String GDModelValue = js2.getString("DataResult.DataLabel[0]");
            String GDApplianceIDValue = js2.getString("DataResult.DataIdentifier[0]");
            System.out.println("Model Number is : " + GDModelValue);
            System.out.println("Unique Appliance ID is : " + GDApplianceIDValue);

            // UpdateTransaction API to update the Unique Appliance ID:
            String UpdateTransactionModelResponse  = given().queryParam("m", "UpdateTransaction")
                    .header("Content-Type", "application/json")
                    .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .body(UpdateTransactionAPI.updateTransactionByUniqueApplianceId(guid,GDApplianceIDValue,channelCode))
                    .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                    .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("UT000"))
                    .extract().response().asString();
            JsonPath js3 = new JsonPath(UpdateTransactionModelResponse);
            String UpdateTransactionModel = js3.getString("ModelNumber");
            String UpdateTransactionApplianceID = js3.getString("UniqueApplianceID");
            System.out.println("Model Number is : " + UpdateTransactionModel);
            System.out.println("Unique Appliance ID is : " + UpdateTransactionApplianceID);

            if(UpdateTransactionModel.equalsIgnoreCase("GDModelValue") && UpdateTransactionApplianceID.equalsIgnoreCase("GDApplianceIDValue"))
            {
                System.out.println("Model Number updated Successfully via UseGetData & UpdateTransaction API");
            }
        }
        else
        {
            System.out.println("Plan already have model No. on it : " + GMModelNumberValue );
        }

//****************************************************************************************************//

        //Update ClaimType via Update Transaction API
        String UpdateTransactionClaimTypeResponse = given().queryParam("m", "UpdateTransaction")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(UpdateTransactionAPI.updateTransactionByClaimType(guid,ClaimTypeValue,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("UT000"))
                .extract().response().asString();

        //Update FaultCategoryID and FaultID via Update Transaction API
        String UpdateTransactionFaultIDAndCategoryResponse = given().queryParam("m", "UpdateTransaction")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(UpdateTransactionAPI.updateTransactionByFaultCategoryAndFaultID(guid,GMFaultCategoryID,GMFaultID,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("UT000"))
                .extract().response().asString();

//****************************************************************************************************//

        //Trigger PutNewClaim API to create and Accepted a claim
        String putNewClaimResponse = given().queryParam("m", "PutNewClaim")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(PutNewClaimAPI.createNewClaimForElectrolux(guid,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("NC000"))
                .extract().response().asString();
        JsonPath js3 = new JsonPath(putNewClaimResponse);
        newClaimID = js3.getString("ClaimID");

//************************************  GetQuestion & PutAnswer API  ****************************************//

        //GetQuestion & PutAnswer API
        String getQuestionResponse = given().queryParam("m", "GetQuestion")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(QuestionAnswerAPI.getQuestionAPI(newClaimID,channelCode))
                .when().log().all().get("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("GQ000"))
                .extract().response().asString();
        JsonPath js4 = new JsonPath(getQuestionResponse);
        questionID = js4.getString("QuestionID");
        answerID = js4.getString("AnswerData[1].AnswerID");

        String putAnswerResponse = given().queryParam("m", "PutAnswer")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(QuestionAnswerAPI.putAnswerAPI(newClaimID,questionID,answerID,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("PA000"))
                .extract().response().asString();
        JsonPath js5 = new JsonPath(putAnswerResponse);
        nextQuestionID = js5.getString("NextQuestionID");
        claimState = js5.getString("ClaimState");
        statusCode = js5.getString("StatusCode");
        if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
        {
            System.out.println("PutAnswer API executed successfully: " + statusCode);
        }

        while (claimState.equalsIgnoreCase("In Progress"))
        {
            String GQResponse = given().queryParam("m", "GetQuestion")
                    .header("Content-Type", "application/json")
                    .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .body(QuestionAnswerAPI.getQuestionID(newClaimID,nextQuestionID,channelCode))
                    .when().log().all().get("/"+env+"/RestAPI/BookClaim/")
                    .then().log().all().assertThat().statusCode(200).body("StatusCode", equalTo("GQ000"))
                    .extract().response().asString();
            JsonPath js6 = new JsonPath(GQResponse);
            questionID1 = js6.getString("QuestionID");
            answerType = js6.getString("AnswerType");
            answerID1 = js6.getString("AnswerData[0].AnswerID");
            System.out.println("Answer Type is : " + answerType);
            if(answerType.equalsIgnoreCase("DROPDOWN"))
            {
                answerID1 = js6.getString("AnswerData.AnswerID");
            }
            if(questionID1.equalsIgnoreCase("358") && answerType.equalsIgnoreCase("RADIO_BUTTONS"))
            {
                answerID1 = js6.getString("AnswerData[3].AnswerID");
            }

            if(answerType.equalsIgnoreCase("RADIO_BUTTONS"))
            {
                String radioButtonPutAnswerResponse = given().queryParam("m", "PutAnswer")
                        .header("Content-Type", "application/json")
                        .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                        .body(QuestionAnswerAPI.putAnswerRadioButton(newClaimID,questionID1,answerID1,channelCode))
                        .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                        .then().log().all().assertThat().statusCode(200).extract().response().asString();
                JsonPath js7 = new JsonPath(radioButtonPutAnswerResponse);
                nextQuestionID = js7.getString("NextQuestionID");
                claimState = js7.getString("ClaimState");
                statusCode = js5.getString("StatusCode");
                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
                {
                    System.out.println("PutAnswer API executed successfully: " + statusCode);
                }


            }
            else if(answerType.equalsIgnoreCase("RESPONSE_FIELD"))
            {
                String responseFieldPutAnswerResponse = given().queryParam("m", "PutAnswer")
                        .header("Content-Type", "application/json")
                        .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                        .body(QuestionAnswerAPI.putAnswerResponseField(newClaimID,questionID1,answerID1,channelCode))
                        .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                        .then().log().all().assertThat().statusCode(200).extract().response().asString();
                JsonPath js8 = new JsonPath(responseFieldPutAnswerResponse);
                nextQuestionID = js8.getString("NextQuestionID");
                claimState = js8.getString("ClaimState");
                statusCode = js5.getString("StatusCode");
                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
                {
                    System.out.println("PutAnswer API executed successfully: " + statusCode);
                }
            }
            else if(answerType.equalsIgnoreCase("DATE"))
            {
                String responseFieldPutAnswerResponse = given().queryParam("m", "PutAnswer")
                        .header("Content-Type", "application/json")
                        .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                        .body(QuestionAnswerAPI.putAnswerDatePicker(newClaimID,questionID1,answerID1,channelCode))
                        .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                        .then().log().all().assertThat().statusCode(200).extract().response().asString();
                JsonPath js9 = new JsonPath(responseFieldPutAnswerResponse);
                nextQuestionID = js9.getString("NextQuestionID");
                claimState = js9.getString("ClaimState");
                statusCode = js5.getString("StatusCode");
                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
                {
                    System.out.println("PutAnswer API executed successfully: " + statusCode);
                }
            }
            else if (answerType.equalsIgnoreCase("DROPDOWN"))
            {
                String responseFieldPutAnswerResponse = given().queryParam("m", "PutAnswer")
                        .header("Content-Type", "application/json")
                        .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                        .body(QuestionAnswerAPI.putAnswerDropdown(newClaimID,questionID1,answerID1,channelCode))
                        .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                        .then().log().all().assertThat().statusCode(200).extract().response().asString();
                JsonPath js10 = new JsonPath(responseFieldPutAnswerResponse);
                nextQuestionID = js10.getString("NextQuestionID");
                claimState = js10.getString("ClaimState");
                statusCode = js5.getString("StatusCode");
                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
                {
                    System.out.println("PutAnswer API executed successfully: " + statusCode);
                }
            }
            else if (answerType.equalsIgnoreCase("LIST"))
            {
                String responseFieldPutAnswerResponse = given().queryParam("m", "PutAnswer")
                        .header("Content-Type", "application/json")
                        .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                        .body(QuestionAnswerAPI.putAnswerList(newClaimID,questionID1,answerID1,channelCode))
                        .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                        .then().log().all().assertThat().statusCode(200).extract().response().asString();
                JsonPath js10 = new JsonPath(responseFieldPutAnswerResponse);
                nextQuestionID = js10.getString("NextQuestionID");
                claimState = js10.getString("ClaimState");
                statusCode = js5.getString("StatusCode");
                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
                {
                    System.out.println("PutAnswer API executed successfully: " + statusCode);
                }
            }
        }
        if(claimState.equalsIgnoreCase("Accepted"))
        {
            System.out.println("Claim successfully Accepted : " + newClaimID);
        }

//************************************ GetServiceOption API ****************************************//

        String getServiceOptionResponse = given().queryParam("m", "GetServiceOption")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(GetServiceOptionAPI.getServiceOptionElux(newClaimID,channelCode))
                .when().log().all().get("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode",equalTo("GS000")).extract().response().asString();
        JsonPath js11 = new JsonPath(getServiceOptionResponse);
        int serviceOptionCount = js11.getInt("ServiceOptions.size()");
        System.out.println("Total service Option Available is : " + serviceOptionCount);
        for( int i=0;i<serviceOptionCount;i++)
        {
            ServiceOptionId = js11.getString("ServiceOptions["+i+"].ServiceOptionID");
            if(ServiceOptionId.equalsIgnoreCase("6")) {
                System.out.println("Home Visit Service Option is available : " + ServiceOptionId);
                break;
            }

        }

//************************************ PutServiceOption API ****************************************//

        String putServiceOptionResponse = given().queryParam("m", "PutServiceOption")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(PutServiceOptionAPI.putServiceOption(newClaimID,ServiceOptionId,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js12 = new JsonPath(putServiceOptionResponse);
        int maximumDaysAvailable = js12.getInt("AvailabilityMaximumDays");
        if(maximumDaysAvailable == 14) {
            System.out.println("Maximum Days Available should be : " + maximumDaysAvailable);
        }
        else {
            System.out.println("We are not getting the 14 days calendar from OEM");
        }
        System.out.println(js12.getString("AvailabilityStartDate"));
        System.out.println(js12.getString("AvailabilityEndDate"));
        int noOfAvailableDays = js12.getInt("AvailabilityData.size()");
        System.out.println("Total No. of slots available: " + noOfAvailableDays);
        String dateSelected = js12.get("AvailabilityData["+(noOfAvailableDays-1)+"].Date").toString();
        System.out.println("Date selected for Appointment Booked : " + dateSelected);
        String slotSelected = js12.get("AvailabilityData["+(noOfAvailableDays-1)+"].Slots.Identifier").toString();
        System.out.println("Slot selected for Appointment Booked : " + slotSelected);

//************************************ PutRepairData API ****************************************//

        String putRepairDataResponse = given().queryParam("m", "PutRepairData")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(PutRepairDataAPI.putRepairData(newClaimID,PlanNo,dateSelected,slotSelected,channelCode))
                .when().log().all().put("/"+env+"/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode",equalTo("RD000")).extract().response().asString();
        JsonPath js13 = new JsonPath(putRepairDataResponse);


    }

    //************************************ Open Claim and Cancel Claim API ****************************************//
    @Test
    public void getOpenClaimDetails()
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        String planNo = "C1Z9056313";
        //Get An Open Claim if exist:
        String getOpenClaimResponse  = given().log().all().queryParam("t","GetAllClaims").queryParam("PolicyNumber",planNo)
                .queryParam("ChannelCode","ORB").queryParam("CountryCode","GB")
                .header("Content-Type", "application/json")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .when().get("/domgenprelive/RestAPI/ClaimsAPI/")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js1 = new JsonPath(getOpenClaimResponse);
        String openClaimNumber = js1.getString("Response.PolicyData."+planNo+".ClaimNumber");
        String openClaimStatus = js1.getString("Response.PolicyData."+planNo+".RepairHistory[0].RepairStatusHistory[0].Status");
        System.out.println("Open Claim No. is : " + openClaimNumber);
        System.out.println("Open Claim No. Status is : " + openClaimStatus);

        //Cancel An Open Claim:
        if(openClaimNumber != null && openClaimStatus != "Repair request cancelled")
        {
            CancelAnOpenClaim.cancelOpenClaim(openClaimNumber,planNo,env);
        } else {
            System.out.println("No Open Claim present for the Plan number : " + planNo);
        }
    }
















}
