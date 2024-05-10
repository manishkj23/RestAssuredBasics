package ApiPayloads;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetServiceOptionAPI {

    public static String getServiceOptionElux(String claimID,String channelCode)
    {
        return "{\n" +
                "  \"ClaimID\": \""+claimID+"\",\n" +
                "  \"CustomerTitle\": \"MR\",\n" +
                "  \"ClaimEmail\": \"tvrs335@mail.com\",\n" +
                "  \"ClaimMobile\": \"07802299909\",\n" +
                "  \"ClaimLandline\": \"01200002546\",\n" +
                "  \"CustomerFirstName\": \"DGDFRTEEN\",\n" +
                "  \"CustomerLastName\": \"REDFEWGJGJKQW\",\n" +
                "  \"CustomersHouseStreetName\": \"2 HANDSIDE LANE\",\n" +
                "  \"CustomersLocalArea\": \"\",\n" +
                "  \"CustomersTownCity\": \"\",\n" +
                "  \"CustomersPostCode\": \"SW19 4JS\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String getServiceOptionWhirlpool(String claimID,String channelCode)
    {
        return "{\n" +
                "  \"ClaimID\": \""+claimID+"\",\n" +
                "  \"CustomerTitle\": \"MR\",\n" +
                "  \"ClaimEmail\": \"tvrs335@mail.com\",\n" +
                "  \"ClaimMobile\": \"07802299909\",\n" +
                "  \"ClaimLandline\": \"01200002546\",\n" +
                "  \"CustomerFirstName\": \"DGDFRTEEN\",\n" +
                "  \"CustomerLastName\": \"REDFEWGJGJKQW\",\n" +
                "  \"CustomersHouseStreetName\": \"100 Hillward Close\",\n" +
                "  \"CustomersLocalArea\": \"\",\n" +
                "  \"CustomersTownCity\": \"\",\n" +
                "  \"CustomersPostCode\": \"PE2 7AB\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String getServiceOptionHooverCandy(String claimID,String channelCode)
    {
        return "{\n" +
                "  \"ClaimID\": \""+claimID+"\",\n" +
                "  \"CustomerTitle\": \"MS\",\n" +
                "  \"ClaimEmail\": \"tvrs335@mail.com\",\n" +
                "  \"ClaimMobile\": \"07802299909\",\n" +
                "  \"ClaimLandline\": \"01200002546\",\n" +
                "  \"CustomerFirstName\": \"ALLISON\",\n" +
                "  \"CustomerLastName\": \"HOOAW-AAAS\",\n" +
                "  \"CustomersHouseStreetName\": \"3 WYKEHAM AVENUE\",\n" +
                "  \"CustomersLocalArea\": \"\",\n" +
                "  \"CustomersTownCity\": \"HORNCHURCH\",\n" +
                "  \"CustomersPostCode\": \"RM11 2LA\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String getServiceOptionBeko(String claimID,String channelCode)
    {
        return "{\n" +
                "  \"ClaimID\": \""+claimID+"\",\n" +
                "  \"CustomerTitle\": \"MR\",\n" +
                "  \"ClaimEmail\": \"tvrs335@mail.com\",\n" +
                "  \"ClaimMobile\": \"07802299909\",\n" +
                "  \"ClaimLandline\": \"01200002546\",\n" +
                "  \"CustomerFirstName\": \"BEKOSITTEST\",\n" +
                "  \"CustomerLastName\": \"CALENDAR\",\n" +
                "  \"CustomersHouseStreetName\": \"64 LEASOWE ROAD\",\n" +
                "  \"CustomersLocalArea\": \"\",\n" +
                "  \"CustomersTownCity\": \"LEEDS\",\n" +
                "  \"CustomersPostCode\": \"LS10 2EZ\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }


    public static String getServiceOptionTest()
    {
        return "{\n" +
                "  \"ClaimID\": \"129126\",\n" +
                "  \"CustomerTitle\": \"MR\",\n" +
                "  \"ClaimEmail\": \"tvrs335@mail.com\",\n" +
                "  \"ClaimMobile\": \"07802299909\",\n" +
                "  \"ClaimLandline\": \"01200002546\",\n" +
                "  \"CustomerFirstName\": \"DAVID\",\n" +
                "  \"CustomerLastName\": \"MKJTESTBAXI-AAAK\",\n" +
                "  \"CustomersHouseStreetName\": \"15 WHITEHILLS RISE\",\n" +
                "  \"CustomersLocalArea\": \"COVE BAY\",\n" +
                "  \"CustomersTownCity\": \"ABERDEEN\",\n" +
                "  \"CustomersPostCode\": \"AB12 3UH\",\n" +
                "  \"ChannelCode\": \"AAT\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }


    @Test
    void getServiceOption()
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        String getServiceOptionResponse = given().log().all().queryParam("m", "GetServiceOption")
                .header("Content-Type", "application/json")
                .header("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .body(GetServiceOptionAPI.getServiceOptionTest())
                .when().get("/domgenprelive/RestAPI/BookClaim/")
                .then().log().all().assertThat().statusCode(200).body("StatusCode",equalTo("GS000"))
                .extract().response().asString();
    }





}
