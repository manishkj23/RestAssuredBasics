package PojoConcept.PojoClasses;

import com.fasterxml.jackson.annotation.JsonSetter;

public class startTransactionRequest {

    private String PlanNumber;
    private String Manufacturer;

    public String getPlanNumber() {
        return PlanNumber;
    }

    @JsonSetter("PlanNumber")
    public void setPlanNumber(String PlanNumber) {
        this.PlanNumber = PlanNumber;
    }

    public String getManufacturer() {
        return Manufacturer;
    }
    @JsonSetter("Manufacturer")
    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getProductType() {
        return ProductType;
    }
    @JsonSetter("ProductType")
    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
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

    private String ProductType;
    private String ChannelCode;
    private String CountryCode;









}
