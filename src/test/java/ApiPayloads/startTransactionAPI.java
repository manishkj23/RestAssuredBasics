package ApiPayloads;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class startTransactionAPI {

    public static String createNewGuid(String PlanNo, String productType, String channelCode, String oem)
    {
        return "{\n" +
        "    \"PlanNumber\": \""+PlanNo+"\",\n" +
                "    \"Manufacturer\": \""+oem+"\",\n" +
                "    \"ProductType\": \""+productType+"\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String createNewGuid1()
    {
        return "{\n" +
                "    \"PlanNumber\": \"CG90009272\",\n" +
                "    \"Manufacturer\": \"ALGOR\",\n" +
                "    \"ProductType\": \"Coffee Machine\",\n" +
                "    \"ChannelCode\": \"AAT\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }

    @Test
    void startTransactionAPI()
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        given().log().all().queryParam("m","StartTransaction")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"PlanNumber\": \"CG90009272\",\n" +
                        "    \"Manufacturer\": \"ALGOR\",\n" +
                        "    \"ProductType\": \"Coffee Machine\",\n" +
                        "    \"ChannelCode\": \"AAT\",\n" +
                        "    \"CountryCode\": \"GB\"\n" +
                        "}")
                .when().put("/domgensit/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200);
    }


}
