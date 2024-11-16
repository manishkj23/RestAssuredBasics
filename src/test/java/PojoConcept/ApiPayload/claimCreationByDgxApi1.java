package PojoConcept.ApiPayload;

import ApiPayloads.startTransactionAPI;
import PojoConcept.PojoClasses.startTransactionRequest;
import PojoConcept.PojoClasses.startTransactionResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class claimCreationByDgxApi1 {

    String nextQuestionID, claimState, answerType, answerID, newClaimID,questionID1,
            answerID1, statusCode, ServiceOptionId;
    String PlanNo = "C1Z9063567", modelNumber = "EWG14", questionID = "", productType="Washing Machine", channelCode = "DGX";
    String env="domgenprelive";
    String oem="BEKO";

//************************************ StartTransaction API: ****************************************************************//
    @Test
    void startTransactionAPI()
    {

        RequestSpecification baseReq = new RequestSpecBuilder().setBaseUri("https://www.skylinecms.co.uk/")
                .setContentType(ContentType.JSON)
                .addHeader("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();

        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        startTransactionRequest stReq = new startTransactionRequest();
        stReq.setPlanNumber(PlanNo);
        stReq.setManufacturer(oem);
        stReq.setProductType("WASHING MACHINE");
        stReq.setChannelCode("DGX");
        stReq.setCountryCode("GB");

        Response stResp = given().log().all().spec(baseReq).queryParam("m","StartTransaction")
                .body(stReq)
                .when().put("/domgensit/RestAPI/BookClaim/")
                .then().log().all().spec(responseSpec).extract().response();
        String startTResponse = stResp.asString();
        System.out.println(startTResponse);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            startTransactionResponse st = mapper.readValue(startTResponse, startTransactionResponse.class);
            String stGuid = st.getGUID();
            System.out.println("GUID successfully fetched via StartTransaction API: " + stGuid);
            String stStatus = st.getStatus();
            System.out.println("Status successfully fetched via StartTransaction API: " + stStatus);
            String stStatusCode = st.getStatusCode();
            System.out.println("StatusCode successfully fetched via StartTransaction API: " + stStatusCode);
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }



}