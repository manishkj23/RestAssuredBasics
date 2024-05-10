package ApiPayloads;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CancelAnOpenClaim {

    public static String cancelOpenClaimAPI(String openClaimNumber, String planNo )
    {
        return "{\n" +
                "    \"ClaimNumber\": \""+openClaimNumber+"\",\n" +
                "    \"PolicyNumber\": \""+planNo+"\",\n" +
                "    \"ClaimCancellationReason\": \"TEST CLAIMS\",\n" +
                "    \"Source\": \"\",\n" +
                "    \"CountryCode\": \"GB\",\n" +
                "    \"LanguageID\": \"\",\n" +
                "    \"Channel\": \"\",\n" +
                "    \"Client\": \"\"\n" +
                "}";
    }


    public static void cancelOpenClaim(String openClaimNumber,String planNo, String env)
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        String cancelClaimResponse = given().log().all().queryParam("t", "PutClaimCancellation")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(CancelAnOpenClaim.cancelOpenClaimAPI(openClaimNumber,planNo))
                .when().log().all().put("/"+env+"/RestAPI/ClaimsAPI/")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js001 = new JsonPath(cancelClaimResponse);
        String responseCode = js001.getString("Response.ResponseCode");
        System.out.println("Response code is : " + responseCode);
        Assert.assertTrue((responseCode.equalsIgnoreCase("SC0001")),"Open Claim Not cancelled properly");
    }


}
