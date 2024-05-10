package PojoConcept.PojoClasses;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRepairData {
    private String ClaimID;
    private String PlanNumber;
    private String Manufacturer;
    private String ModelNumber;
    private String ItemType;
    private String ClaimStatusName;

    public String getClaimID() {
        return ClaimID;
    }

    public void setClaimID(String claimID) {
        ClaimID = claimID;
    }

    public String getPlanNumber() {
        return PlanNumber;
    }

    public void setPlanNumber(String planNumber) {
        PlanNumber = planNumber;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String modelNumber) {
        ModelNumber = modelNumber;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public String getClaimStatusName() {
        return ClaimStatusName;
    }

    public void setClaimStatusName(String claimStatusName) {
        ClaimStatusName = claimStatusName;
    }

    @Test
    void GetRepairData()
    {
        RestAssured.baseURI = "https://www.skylinecms.co.uk/";
        given().log().all().queryParam("m","GetRepairData").queryParam("ClaimID","11130417")
                .queryParam("ChannelCode","ORB").queryParam("CountryCode","GB")
                .header("SynergyToken","7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                .when().get("/domgensit/RestAPI/ClaimData/")
                .then().assertThat().statusCode(200).log().all();
    }
}
