package com.test.StepDefinition;
import com.test.API.apiBuilder;
import com.test.APIUtils.Resources;
import com.test.APIUtils.Utils;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.junit.Assert;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class electroluxStepDefinition extends Utils {

    RequestSpecification stRequestSpec;
    ResponseSpecification stResponseSpec;
    Response stResponse;
    apiBuilder apiBuild = new apiBuilder();
    static String GUID,UniqueApplianceID, ModelNo, FaultCategory, FaultID, ClaimType,NewClaimID,ServiceOptionId,
            psDateSelected,psSlotSelected,openClaimNumber,openClaimStatusHistory,newDateToRebook,newSlotsIdentifier,
            openClaimStatus;
    static String AnswerID,nextQuestionID,claimState,answerType,questionID1,answerID1;
    static String QuestionID="";
    public String postCode;

//    public electroluxStepDefinition() {
////        this.postCode = postCode;
//    }
//
//    public String getPostCode() {
//        return postCode;
//    }
//
//    public void setPostCode(String postCode) {
//        this.postCode = postCode;
//    }



    @Given("StartTransaction Payload with {string} {string} {string}")
    public void start_transaction_payload_with(String PlanNo, String OEM, String productType) throws IOException {
        if(openClaimStatus == null && openClaimNumber == null)
        {
            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "StartTransaction")
                    .body(apiBuild.startTransactionPayload(PlanNo, OEM, productType));
        }
        else if(openClaimStatusHistory.equalsIgnoreCase("Repair In Progress") || openClaimNumber != null || openClaimStatus.equalsIgnoreCase("Accepted"))
        {
            cancellation_payload_with_and_open(PlanNo,openClaimNumber);
            user_calls_api_with_put_method("Cancellation","POST");
            i_api_call_is_success_with_status_code(200);

            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "StartTransaction")
                    .body(apiBuild.startTransactionPayload(PlanNo, OEM, productType));
        }
    }

    @When("User calls {string} API with {string} method")
    public void user_calls_api_with_put_method(String resourcesURL, String apiMethod) {

        //constructor will be called with value of resource which you pass from Enum class
        if (apiMethod.equalsIgnoreCase("PUT")) {
            Resources endpointResources = Resources.valueOf(resourcesURL);
            System.out.println(endpointResources.getResourcesURL());
            stResponse = stRequestSpec.when().log().all().put(endpointResources.getResourcesURL())
            .then().log().all().extract().response();

        } else if (apiMethod.equalsIgnoreCase("GET")) {
            Resources endpointResources = Resources.valueOf(resourcesURL);
            System.out.println(endpointResources.getResourcesURL());
            stResponse = stRequestSpec.when().log().all().get(endpointResources.getResourcesURL())
                    .then().log().all().extract().response();

        } else if (apiMethod.equalsIgnoreCase("POST")) {
            Resources endpointResources = Resources.valueOf(resourcesURL);
            System.out.println(endpointResources.getResourcesURL());
            stResponse = stRequestSpec.when().log().all().post(endpointResources.getResourcesURL())
                    .then().log().all().extract().response();

        }
    }

    @Then("I verify API call is success with status code {int}")
    public void i_api_call_is_success_with_status_code(Integer int1) {
        Assert.assertEquals(stResponse.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void verifyStatusCodeinResponseBody(String status, String expectedValue) {
        Assert.assertEquals(getJsonPath(stResponse, status), expectedValue);
    }

    @And("I get the Post Code of the {string}")
    public void i_get_the_post_code_of_the(String planNo) {

        String planNumber = getJsonPath(stResponse,"PlanNumber");
        if(planNumber.equalsIgnoreCase(planNo))
        {
            postCode = getJsonPath(stResponse,"PostalCode");
            System.out.println("Post code is :" +  postCode);
        }
        else
        {
            System.out.println("Plan no. is not correct");
        }




    }

    @Then("I verify {string} created after triggered the Start Transaction API")
    public void i_verify_guid_created_after_triggered_the_start_transaction_api(String guid) {
        GUID = getJsonPath(stResponse,guid);
        System.out.println("GUID created successfully : " + GUID);
    }

    @Given("GetMandatoryData Payload with {string}")
    public void getMandatoryData_payload_with_method(String guid) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetMandatoryData")
                .body(apiBuild.getMandatoryDataPayload(GUID));
    }

    @Then("I get UniqueApplianceID, ModelNo, FaultCategory, FaultID, ClaimType for {string}")
    public void i_get_unique_appliance_id_model_no_fault_category_fault_id_claim_type(String oem) {

        switch(oem){

            case "ELECTROLUX":
                UniqueApplianceID = getJsonPath(stResponse, "UniqueApplianceID");
                ModelNo = getJsonPath(stResponse, "ModelNumber");
                FaultCategory = getJsonPath(stResponse, "FaultData[0].FaultCategoryID");
                FaultID = getJsonPath(stResponse, "FaultData[0].PossibleAnswers[0].FaultID");
                ClaimType = getJsonPath(stResponse, "ClaimTypes[0].ClaimTypeID");
                System.out.println("Unique Appliance ID is : " + UniqueApplianceID);
                System.out.println("Model Number is : " + ModelNo);
                System.out.println("Fault Category ID is : " + FaultCategory);
                System.out.println("Fault ID is : " + FaultID);
                System.out.println("Claim Type value is : " + ClaimType);
                break;

            case "BEKO":
                UniqueApplianceID = getJsonPath(stResponse, "UniqueApplianceID");
                ModelNo = getJsonPath(stResponse, "ModelNumber");
                FaultCategory = getJsonPath(stResponse, "FaultData.FaultCategoryID");
                FaultID = getJsonPath(stResponse, "FaultData.PossibleAnswers[0].FaultID");
                ClaimType = getJsonPath(stResponse, "ClaimTypes[0].ClaimTypeID");
                System.out.println("Unique Appliance ID is : " + UniqueApplianceID);
                System.out.println("Model Number is : " + ModelNo);
                System.out.println("Fault Category ID is : " + FaultCategory);
                System.out.println("Fault ID is : " + FaultID);
                System.out.println("Claim Type value is : " + ClaimType);
                break;
        }
    }

    @Given("GetData Payload with {string}, {string}")
    public void getData_payload_with_method(String guid, String searchModel) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetData")
                .body(apiBuild.getDataPayload(GUID,searchModel));
     }

    @Given("I verify if UniqueApplianceID is null and update {string} with {string}")
    public void i_verify_if_unique_appliance_id_is_null_and_update_with(String searchModel, String resourcesURL) throws IOException {
        if(UniqueApplianceID == null)
        {
            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetData")
                    .body(apiBuild.getDataPayload(GUID,searchModel));
            Resources endpointResources = Resources.valueOf(resourcesURL);
            stResponse = stRequestSpec.when().log().all().get(endpointResources.getResourcesURL())
                    .then().log().all().extract().response();
            Assert.assertEquals("GD000",getJsonPath(stResponse,"StatusCode"));
            UniqueApplianceID = getJsonPath(stResponse,"DataResult[0].DataIdentifier");
        }
        else
        {
            System.out.println("Model Number already present on the plan : " + UniqueApplianceID+ "&" + ModelNo);
        }
    }

    @Given("UpdateTransaction Payload with {string} and {string}")
    public void updateTransaction_payload_with_method(String guid,String parameters) throws IOException {
        if (parameters.equalsIgnoreCase("UniqueAppliance")) {
            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "UpdateTransaction")
                    .body(apiBuild.updateTransactionUniqueApplianceIDPayload(GUID, UniqueApplianceID));
        } else {
            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "UpdateTransaction")
                    .body(apiBuild.updateTransactionClaimTypePayload(GUID, ClaimType));
        }
    }

    @Given("UpdateTransaction Payload with {string},{string},{string}")
    public void updateTransaction_payload_with_method(String guid,String faultCategoryID,String faultID) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "UpdateTransaction")
                .body(apiBuild.updateTransactionFaultCategoryIDPayload(GUID,FaultCategory,FaultID));
    }

    @Given("PutNewClaim Payload with {string},{string},{string}")
    public void put_new_claim_payload_with(String guid, String firstname, String lastname) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutNewClaim")
                .body(apiBuild.putNewClaimPayload(GUID,Utils.getGlobalValues("customerFirstName")
                        ,Utils.getGlobalValues("customerLastName")));

    }

    @Given("I verify new claimID created successfully via PutNewClaim API")
    public void i_verify_new_claim_id_created_successfully_via_put_new_claim_api() {
        NewClaimID = getJsonPath(stResponse,"ClaimID");
        if(NewClaimID != null)
        {
            System.out.println("New Claim ID is not created successfully");
        }
        else
        {
            System.out.println("New Claim ID created successfully");
        }
    }

    @Given("GetQuestion Payload with {string}")
    public void get_question_payload_with(String string) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetQuestion")
                .body(apiBuild.getQuestions(NewClaimID));
    }

    @Then("I verify the questionID & answerID gets generated")
    public void i_verify_the_question_id_answer_id_gets_generated() {
        QuestionID = getJsonPath(stResponse,"QuestionID");
        AnswerID = getJsonPath(stResponse,"AnswerData[1].AnswerID");
    }

    @Given("PutAnswer Payload with {string} {string} {string}")
    public void putAnswerPayload(String string1, String string2, String string3) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                .body(apiBuild.putAnswer(NewClaimID,QuestionID,AnswerID));
    }

    @Then("I verify nextQuestionID gets generated and status is not accepted")
    public void verifyNextQuestionIDGeneratedAndStatusNotAccepted() {
        nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
        claimState = getJsonPath(stResponse,"ClaimState");
    }

    @Given("I complete the Question Answer Tree")
    public void i_complete_the_question_answer_tree() throws IOException {

        while (claimState.equalsIgnoreCase("In Progress"))
        {
            stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetQuestion")
                    .body(apiBuild.getNextQuestionID(NewClaimID,nextQuestionID));
            user_calls_api_with_put_method("GetQuestion","GET");
            questionID1 = getJsonPath(stResponse,"QuestionID");
            answerType = getJsonPath(stResponse,"AnswerType");
            answerID1 = getJsonPath(stResponse,"AnswerData[0].AnswerID");
            System.out.println("Answer Type is : " + answerType);
            if(answerType.equalsIgnoreCase("DROPDOWN"))
            {
                answerID1 = getJsonPath(stResponse,"AnswerData.AnswerID");
            }
            if(questionID1.equalsIgnoreCase("358") && answerType.equalsIgnoreCase("RADIO_BUTTONS"))
            {
                answerID1 = getJsonPath(stResponse,"AnswerData[3].AnswerID");
            }

            if(answerType.equalsIgnoreCase("RADIO_BUTTONS"))
            {
                stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                        .body(apiBuild.putAnswerRadioButton(NewClaimID,questionID1,answerID1));
                user_calls_api_with_put_method("PutAnswer","PUT");

                nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
                claimState = getJsonPath(stResponse,"ClaimState");
//                statusCode = getJsonPath(stResponse,"StatusCode");
//                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
//                {
//                    System.out.println("PutAnswer API executed successfully: " + statusCode);
//                }
            }
            else if(answerType.equalsIgnoreCase("RESPONSE_FIELD"))
            {
                stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                        .body(apiBuild.putAnswerResponseField(NewClaimID,questionID1,answerID1));
                user_calls_api_with_put_method("PutAnswer","PUT");
                nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
                claimState = getJsonPath(stResponse,"ClaimState");
//                statusCode = js5.getString("StatusCode");
//                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
//                {
//                    System.out.println("PutAnswer API executed successfully: " + statusCode);
//                }
            }
            else if(answerType.equalsIgnoreCase("DATE"))
            {
                stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                        .body(apiBuild.putAnswerDatePicker(NewClaimID,questionID1,answerID1));
                user_calls_api_with_put_method("PutAnswer","PUT");
                nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
                claimState = getJsonPath(stResponse,"ClaimState");
//                statusCode = js5.getString("StatusCode");
//                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
//                {
//                    System.out.println("PutAnswer API executed successfully: " + statusCode);
//                }
            }
            else if (answerType.equalsIgnoreCase("DROPDOWN"))
            {
                stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                        .body(apiBuild.putAnswerDropdown(NewClaimID,questionID1,answerID1));
                user_calls_api_with_put_method("PutAnswer","PUT");
                nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
                claimState = getJsonPath(stResponse,"ClaimState");
//                statusCode = js5.getString("StatusCode");
//                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
//                {
//                    System.out.println("PutAnswer API executed successfully: " + statusCode);
//                }
            }
            else if (answerType.equalsIgnoreCase("LIST"))
            {
                stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutAnswer")
                        .body(apiBuild.putAnswerList(NewClaimID,questionID1,answerID1));
                user_calls_api_with_put_method("PutAnswer","PUT");
                nextQuestionID = getJsonPath(stResponse,"NextQuestionID");
                claimState = getJsonPath(stResponse,"ClaimState");
//                statusCode = js5.getString("StatusCode");
//                if(statusCode.equalsIgnoreCase("PA000") || statusCode.equalsIgnoreCase("PA002"))
//                {
//                    System.out.println("PutAnswer API executed successfully: " + statusCode);
//                }
            }
        }
        if(claimState.equalsIgnoreCase("Accepted"))
        {
            System.out.println("Claim successfully Accepted : " + NewClaimID);
        }

    }

    @Given("GetServiceOption Payload with {string} {string} {string}")
    public void get_service_option_payload_with(String string, String string2, String string3) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "GetServiceOption")
                .body(apiBuild.getServiceOptionPayload(NewClaimID,Utils.getGlobalValues("customerFirstName")
                        ,Utils.getGlobalValues("customerLastName")));
    }

    @Given("I verify list of Service Option displayed")
    public void i_verify_list_of_service_option_displayed() {
        int serviceOptionListCount = Integer.parseInt(getJsonPath(stResponse,"ServiceOptions.size()"));
        System.out.println("Total service Option Available is : " + serviceOptionListCount);
        for( int i=0;i<serviceOptionListCount;i++)
        {
            ServiceOptionId = getJsonPath(stResponse,"ServiceOptions["+i+"].ServiceOptionID");
            if(ServiceOptionId.equalsIgnoreCase("6")) {
                System.out.println("Home Visit Service Option is available : " + ServiceOptionId);
                break;
            }
        }
    }

    @Given("PutServiceOption Payload with {string} {string}")
    public void put_service_option_payload_with(String string, String string2) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutServiceOption")
                .body(apiBuild.putServiceOptionPayload(NewClaimID,ServiceOptionId));
    }

    @Given("I get date and slot from the response for the {string}")
    public void i_get_date_and_slot_from_the_response(String oem) {
        switch(oem) {
            case "ELECTROLUX":
            if (oem.equalsIgnoreCase("ELECTROLUX")) {
                int maximumDaysAvailable = Integer.parseInt(getJsonPath(stResponse, "AvailabilityMaximumDays"));
                if (maximumDaysAvailable == 14) {
                    System.out.println("Maximum Days Available should be : " + maximumDaysAvailable);
                } else {
                    System.out.println("We are not getting the 14 days calendar from OEM");
                }
                System.out.println(getJsonPath(stResponse, "AvailabilityStartDate"));
                System.out.println(getJsonPath(stResponse, "AvailabilityEndDate"));
                int noOfAvailableDays = Integer.parseInt((getJsonPath(stResponse, "AvailabilityData.size()")));
                System.out.println("Total No. of slots available: " + noOfAvailableDays);
                psDateSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Date");
                System.out.println("Date selected for Appointment Booked : " + psDateSelected);
                psSlotSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Slots.Identifier");
                System.out.println("Slot selected for Appointment Booked : " + psSlotSelected);
                break;
            }
            case "WHIRLPOOL":
            if (oem.equalsIgnoreCase("WHIRLPOOL")) {
                int maximumDaysAvailable = Integer.parseInt(getJsonPath(stResponse, "AvailabilityMaximumDays"));
                if (maximumDaysAvailable == 7) {
                    System.out.println("Maximum Days Available should be : " + maximumDaysAvailable);
                } else {
                    System.out.println("We are not getting the 7 days calendar from OEM");
                }
                System.out.println(getJsonPath(stResponse, "AvailabilityStartDate"));
                System.out.println(getJsonPath(stResponse, "AvailabilityEndDate"));
                int noOfAvailableDays = Integer.parseInt((getJsonPath(stResponse, "AvailabilityData.size()")));
                System.out.println("Total No. of slots available: " + noOfAvailableDays);
                psDateSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Date");
                System.out.println("Date selected for Appointment Booked : " + psDateSelected);
                psSlotSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Slots[2].Identifier");
                System.out.println("Slot selected for Appointment Booked : " + psSlotSelected);
                break;
            }
            case "BEKO":
                if (oem.equalsIgnoreCase("BEKO")) {
                    int maximumDaysAvailable = Integer.parseInt(getJsonPath(stResponse, "AvailabilityMaximumDays"));
                    if (maximumDaysAvailable == 7) {
                        System.out.println("Maximum Days Available should be : " + maximumDaysAvailable);
                    } else {
                        System.out.println("We are not getting the 7 days calendar from OEM");
                    }
                    System.out.println(getJsonPath(stResponse, "AvailabilityStartDate"));
                    System.out.println(getJsonPath(stResponse, "AvailabilityEndDate"));
                    int noOfAvailableDays = Integer.parseInt((getJsonPath(stResponse, "AvailabilityData.size()")));
                    System.out.println("Total No. of slots available: " + noOfAvailableDays);
                    psDateSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Date");
                    System.out.println("Date selected for Appointment Booked : " + psDateSelected);
                    psSlotSelected = getJsonPath(stResponse, "AvailabilityData[" + (noOfAvailableDays - 1) + "].Slots.Identifier");
                    System.out.println("Slot selected for Appointment Booked : " + psSlotSelected);
                    break;
                }
        }
    }

    @Given("PutRepairData Payload with {string} {string} {string} {string}")
    public void put_repair_data_payload_with(String claimID, String planNo, String string3, String string4) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m", "PutRepairData")
                .body(apiBuild.putRepairDataPayload(NewClaimID,planNo,psDateSelected,psSlotSelected));
    }

    @Given("GetAllClaim Payload with {string}")
    public void get_all_claim_payload_with(String planNo) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("t","GetAllClaims")
                .queryParam("PolicyNumber",planNo).queryParam("ChannelCode",getGlobalValues("channelCode"))
                .queryParam("CountryCode",getGlobalValues("countryCode"));

    }

    @Then("I verify the Open claim is present for {string}")
    public void i_verify_the_open_claim_is_present(String planNo) {
        openClaimNumber = getJsonPath(stResponse,"Response.PolicyData."+planNo+".ClaimNumber");
        openClaimStatusHistory = getJsonPath(stResponse,"Response.PolicyData."+planNo+".RepairHistory[0].RepairStatusHistory[0].Status");
        openClaimStatus = getJsonPath(stResponse,"Response.PolicyData."+planNo+".ClaimStatus");
        System.out.println("Open Claim No. is : " + openClaimNumber);
        System.out.println("Open Claim No. history Status is : " + openClaimStatusHistory);
        System.out.println("Open Claim No. Status is : " + openClaimStatus);
    }

    @Given("Cancellation Payload with {string} and Open {string}")
    public void cancellation_payload_with_and_open(String planNo, String claimNo) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification())
                .body(apiBuild.cancellationPayload(planNo,openClaimNumber));
    }

    @Given("GetNewAppointments Payload with {string}")
    public void get_new_appointments_payload_with(String claimNo) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m","GetNewAppointments")
                .queryParam("ClaimID",NewClaimID).queryParam("ChannelCode",getGlobalValues("channelCode"))
                .queryParam("CountryCode",getGlobalValues("countryCode"))
                .queryParam("AvailabilityStartDate","")
                .queryParam("AvailabilityEndDate","");
    }

    @And("I verify the current appointment date and get new date and slot")
    public void verifyTheCurrentAppointmentDateAndNewDateSlot() {
        String currentAppointmentDate = getJsonPath(stResponse,"CurrentAppointment.Date");
        JsonPath jsonPath = new JsonPath(stResponse.asString());
        int numberOfAvailabilityDays = jsonPath.getList("AvailabilityData").size();
        newDateToRebook = getJsonPath(stResponse,"AvailabilityData["+(numberOfAvailabilityDays-2)+"].Date");
        newSlotsIdentifier = getJsonPath(stResponse,"AvailabilityData["+(numberOfAvailabilityDays-2)+"].Slots.Identifier");
        System.out.println("New date is :" + newDateToRebook);
        System.out.println("New slotIdentifier is: " + newSlotsIdentifier);
        System.out.println("Total Days Available are: " + numberOfAvailabilityDays);
        if(currentAppointmentDate.equalsIgnoreCase(newDateToRebook))
        {
            System.out.println("New date and current date both are same ");
            newDateToRebook = getJsonPath(stResponse,"AvailabilityData["+(numberOfAvailabilityDays-3)+"].Date");
            newSlotsIdentifier = getJsonPath(stResponse,"AvailabilityData["+(numberOfAvailabilityDays-3)+"].Slots.Identifier");
            System.out.println("New date is: " + newDateToRebook);
            System.out.println("New Slot Identifier is: " + newSlotsIdentifier);
        }
        else
        {
            System.out.println("New date and current date both are different and can rebook an appointment ");
        }

        //To fetch & display all the dates in the response
//        for( int i=0;i<numberOfAvailabilityDays;i++)
//        {
//            String dataDate = getJsonPath(stResponse,"AvailabilityData["+i+"].Date");
//            System.out.println("Dates are: " + dataDate);
//        }
    }

    @Given("PutNewAppointment Payload with ClaimNo & SlotIdentifier")
    public void putNewAppointmentPayloadClaimNoSlotIdentifier() throws IOException, InterruptedException {
        Thread.sleep(5000);
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m","PutNewAppointment")
                .body(apiBuild.putNewAppointmentPayload(NewClaimID,newSlotsIdentifier));
    }

    @Then("I verify {string} ClaimNo is same after rebooked an appointment")
    public void i_verify_claim_no_is_same_after_rebooked_an_appointment(String planNo) {
        String pnaPlanNo = getJsonPath(stResponse,"PlanNumber");
        String pnaClaimNo = getJsonPath(stResponse,"ClaimID");
        Assert.assertTrue("Rebook an appointment is not done for the correct plan",
                pnaPlanNo.equalsIgnoreCase(planNo) && pnaClaimNo.equalsIgnoreCase(NewClaimID));
    }

    @And("I verify the current appointment date and new date and slot for {string}")
    public void verifyCurrentAppointmentDateAndNewDateSlot(String oem) {

        switch (oem) {
            case "ELECTROLUX", "BEKO":
                String currentAppointmentDate = getJsonPath(stResponse, "CurrentAppointment.Date");
                JsonPath jsElux = new JsonPath(stResponse.asString());
                int eluxNumberOfAvailabilityDays = jsElux.getList("AvailabilityData").size();
                newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (eluxNumberOfAvailabilityDays - 2) + "].Date");
                newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (eluxNumberOfAvailabilityDays - 2) + "].Slots.Identifier");
                if (currentAppointmentDate.equalsIgnoreCase(newDateToRebook)) {
                    System.out.println("New date and current date both are same ");
                    newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (eluxNumberOfAvailabilityDays - 3) + "].Date");
                    newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (eluxNumberOfAvailabilityDays - 3) + "].Slots.Identifier");
                    System.out.println("New date is: " + newDateToRebook);
                    System.out.println("New Slot Identifier is: " + newSlotsIdentifier);
                } else {
                    System.out.println("New date and current date both are different and can rebook an appointment ");
                }
                break;
            //To fetch & display all the dates in the response
//            for (int i = 0; i < eluxNumberOfAvailabilityDays; i++) {
//                String dataDate = getJsonPath(stResponse, "AvailabilityData[" + i + "].Date");
//                System.out.println("Dates are: " + dataDate);

            case "WHIRLPOOL":
                String WHPLCurrentAppointmentDate = getJsonPath(stResponse, "CurrentAppointment.Date");
                JsonPath jsWhpl = new JsonPath(stResponse.asString());
                int whplNumberOfAvailabilityDays = jsWhpl.getList("AvailabilityData").size();
                newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (whplNumberOfAvailabilityDays - 2) + "].Date");
                newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (whplNumberOfAvailabilityDays - 2) + "].Slots[" + (whplNumberOfAvailabilityDays - 2) + "].Identifier");
                if (WHPLCurrentAppointmentDate.equalsIgnoreCase(newDateToRebook)) {
                    System.out.println("New date and current date both are same ");
                    newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (whplNumberOfAvailabilityDays - 3) + "].Date");
                    newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (whplNumberOfAvailabilityDays - 3) + "].Slots[" + (whplNumberOfAvailabilityDays - 3) + "].Identifier");
                    System.out.println("New date is: " + newDateToRebook);
                    System.out.println("New Slot Identifier is: " + newSlotsIdentifier);
                } else {
                    System.out.println("New date and current date both are different and can rebook an appointment ");
                }
                break;
            //To fetch & display all the dates in the response
//                for (int i = 0; i < whplNumberOfAvailabilityDays; i++) {
//                    String dataDate = getJsonPath(stResponse, "AvailabilityData[" + i + "].Date");
//                    System.out.println("Dates are: " + dataDate);
//                }

//            case "BEKO":
//                String bekoCurrentAppointmentDate = getJsonPath(stResponse, "CurrentAppointment.Date");
//                JsonPath jsBeko = new JsonPath(stResponse.asString());
//                int bekoNumberOfAvailabilityDays = jsBeko.getList("AvailabilityData").size();
//                newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (bekoNumberOfAvailabilityDays - 2) + "].Date");
//                newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (bekoNumberOfAvailabilityDays - 2) + "].Slots.Identifier");
//                if (bekoCurrentAppointmentDate.equalsIgnoreCase(newDateToRebook)) {
//                    System.out.println("New date and current date both are same ");
//                    newDateToRebook = getJsonPath(stResponse, "AvailabilityData[" + (bekoNumberOfAvailabilityDays - 3) + "].Date");
//                    newSlotsIdentifier = getJsonPath(stResponse, "AvailabilityData[" + (bekoNumberOfAvailabilityDays - 3) + "].Slots.Identifier");
//                    System.out.println("New date is: " + newDateToRebook);
//                    System.out.println("New Slot Identifier is: " + newSlotsIdentifier);
//                } else {
//                    System.out.println("New date and current date both are different and can rebook an appointment ");
//                }
//                break;

        }
    }

    @Given("GetRepairData Payload with {string}")
    public void get_repair_data_payload_with(String claimNo) throws IOException {
        stRequestSpec = given().log().all().spec(requestSpecification()).queryParam("m","GetRepairData")
                .queryParam("ClaimID",claimNo).queryParam("ChannelCode",getGlobalValues("channelCode"))
                .queryParam("CountryCode",getGlobalValues("countryCode"));
    }

    @Then("I verify the {string} {string} {string} {string} {string}")
    public void i_verify_the(String PlanNo, String oem, String productType, String claimNo, String modelNo) {
        String grPlanNo = getJsonPath(stResponse,"PlanNumber");
        String grClaimNo = getJsonPath(stResponse,"ClaimID");
        String grManufacturer = getJsonPath(stResponse,"Manufacturer");
        String grModelNumber = getJsonPath(stResponse,"ModelNumber");
        String grAppointmentDateSelected = getJsonPath(stResponse,"AppointmentDateSelected");
        String grItemType = getJsonPath(stResponse,"ItemType");
        String grRebookAllowed = getJsonPath(stResponse,"RebookAllowed");
        String grCancellationAllowed = getJsonPath(stResponse,"CancellationAllowed");
        String grBookingCancellationAllowed = getJsonPath(stResponse,"BookingCancellationAllowed");
        String grAppointmentTrackingAllowed = getJsonPath(stResponse,"AppointmentTrackingAllowed");
        System.out.println("Get Repair Plan Number is : " + grPlanNo);
        System.out.println("Get Repair Claim Number is : " + grClaimNo);
        System.out.println("Get Repair Manufacturer is : " + grManufacturer);
        System.out.println("Get Repair Model No. is : " + grModelNumber);
        System.out.println("Get Repair Appointment Date selected is : " + grAppointmentDateSelected);
        System.out.println("Get Repair Product Type is : " + grItemType);
        System.out.println("Get Repair Rebooked Allowed Indicator is : " + grRebookAllowed);
        System.out.println("Get Repair Cancellation Allowed Indicator is : " + grCancellationAllowed);
        System.out.println("Get Repair Booking Cancellation Allowed Indicator is: " + grBookingCancellationAllowed);
        System.out.println("Get Repair Appointment Tracking Allowed Indicator is : " + grAppointmentTrackingAllowed);
        if(PlanNo.equalsIgnoreCase(grPlanNo) && oem.equalsIgnoreCase(grManufacturer)
                && claimNo.equalsIgnoreCase(grClaimNo))
        {
            System.out.println("Get Repair Data response is belongs to: " +PlanNo);
        }
        else
        {
            System.out.println("Get Repair Data response is not correct and doesn't belongs to: " + PlanNo);
        }



    }


}