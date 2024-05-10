package PojoConcept.PojoClasses;

import com.fasterxml.jackson.annotation.JsonSetter;

public class putNewClaimRequest {

    private String GUID;
    private String CustomerTitle;
    private String ClaimEmail;
    private String ClaimMobile;
    private String ClaimLandline;
    private String CustomerFirstName;
    private String CustomerLastName;
    private String CustomersHouseStreetName;
    private String CustomersLocalArea;
    private String CustomersTownCity;
    private String CustomersPostCode;
    private String ChannelCode;
    private String CountryCode;

    public String getGUID() {
        return GUID;
    }

    @JsonSetter("GUID")
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getCustomerTitle() {
        return CustomerTitle;
    }

    @JsonSetter("CustomerTitle")
    public void setCustomerTitle(String CustomerTitle) {
        this.CustomerTitle = CustomerTitle;
    }

    public String getClaimEmail() {
        return ClaimEmail;
    }
    @JsonSetter("ClaimEmail")
    public void setClaimEmail(String ClaimEmail) {
        this.ClaimEmail = ClaimEmail;
    }

    public String getClaimMobile() {
        return ClaimMobile;
    }
    @JsonSetter("ClaimMobile")
    public void setClaimMobile(String ClaimMobile) {
        this.ClaimMobile = ClaimMobile;
    }

    public String getClaimLandline() {
        return ClaimLandline;
    }
    @JsonSetter("ClaimLandline")
    public void setClaimLandline(String ClaimLandline) {
        this.ClaimLandline = ClaimLandline;
    }

    public String getCustomerFirstName() {
        return CustomerFirstName;
    }
    @JsonSetter("CustomerFirstName")
    public void setCustomerFirstName(String CustomerFirstName) {
        this.CustomerFirstName = CustomerFirstName;
    }

    public String getCustomerLastName() {
        return CustomerLastName;
    }
    @JsonSetter("CustomerLastName")
    public void setCustomerLastName(String CustomerLastName) {
        this.CustomerLastName = CustomerLastName;
    }

    public String getCustomersHouseStreetName() {
        return CustomersHouseStreetName;
    }
    @JsonSetter("CustomersHouseStreetName")
    public void setCustomersHouseStreetName(String CustomersHouseStreetName) {
        this.CustomersHouseStreetName = CustomersHouseStreetName;
    }

    public String getCustomersLocalArea() {
        return CustomersLocalArea;
    }
    @JsonSetter("CustomersLocalArea")
    public void setCustomersLocalArea(String CustomersLocalArea) {
        this.CustomersLocalArea = CustomersLocalArea;
    }

    public String getCustomersTownCity() {
        return CustomersTownCity;
    }
    @JsonSetter("CustomersTownCity")
    public void setCustomersTownCity(String CustomersTownCity) {
        this.CustomersTownCity = CustomersTownCity;
    }

    public String getCustomersPostCode() {
        return CustomersPostCode;
    }
    @JsonSetter("CustomersPostCode")
    public void setCustomersPostCode(String CustomersPostCode) {
        this.CustomersPostCode = CustomersPostCode;
    }

    public String getChannelCode() {
        return ChannelCode;
    }
    @JsonSetter("ChannelCode")
    public void setChannelCode(String ChannelCode) {
        this.ChannelCode = ChannelCode;
    }

    public String getCountryCode() {
        return CountryCode;
    }
    @JsonSetter("CountryCode")
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }




}
