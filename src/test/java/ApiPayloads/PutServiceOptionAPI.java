package ApiPayloads;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutServiceOptionAPI {

    public static String putServiceOption(String claimID, String ServiceOptionID, String channelCode)
    {
        return "{\n" +
                "  \"ClaimID\": \""+claimID+"\",\n" +
                "  \"ServiceOptionID\": \""+ServiceOptionID+"\",\n" +
                "  \"ServiceOptionRequiredFields\": [],\n" +
                "  \"AvailabilityStartDate\" : \"\",\n" +
                "  \"AvailabilityEndDate\" : \"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    @Test
    public static void putServiceOptionTest()
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        String putServiceOptionResponse = given().queryParam("m", "PutServiceOption")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body("{\n" +
                        "  \"ClaimID\": \"129455\",\n" +
                        "  \"ServiceOptionID\": \"6\",\n" +
                        "  \"ServiceOptionRequiredFields\": [],\n" +
                        "  \"AvailabilityStartDate\" : \"\",\n" +
                        "  \"AvailabilityEndDate\" : \"\",\n" +
                        "  \"ChannelCode\": \"DGX\",\n" +
                        "  \"CountryCode\": \"GBR\"\n" +
                        "}")
                .when().log().all().put("/domgenprelive/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode",equalTo("PS000")).extract().response().asString();
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

    }











}
