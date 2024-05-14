package PojoConcept.PojoClasses;

import com.fasterxml.jackson.annotation.JsonSetter;

public class CancellationRequest {

    private String ClaimID;
    private String PlanNumber;
    private String CountryCode;
    private String ChannelCode;

    public String getClaimID() {
        return ClaimID;
    }
    @JsonSetter("ClaimID")
    public void setClaimID(String ClaimID) {this.ClaimID = ClaimID; }

    public String getPlanNumber() {
        return PlanNumber;
    }
    @JsonSetter("PlanNumber")
    public void setPlanNumber(String PlanNumber) {
        this.PlanNumber = PlanNumber;
    }

    public String getCountryCode() {
        return CountryCode;
    }
    @JsonSetter("CountryCode")
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getChannelCode() {
        return ChannelCode;
    }
    @JsonSetter("ChannelCode")
    public void setChannelCode(String ChannelCode) {
        this.ChannelCode = ChannelCode;
    }

}
