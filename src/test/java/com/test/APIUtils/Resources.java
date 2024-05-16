package com.test.APIUtils;

public enum Resources {

    //Enum is a special class in Java which has collections of constant or methods

    StartTransaction("/domgenprelive/RestAPI/BookClaim/"),
    GetMandatoryData("/domgenprelive/RestAPI/BookClaim/"),
    GetData("/domgenprelive/RestAPI/BookClaim/"),
    UpdateTransaction("/domgenprelive/RestAPI/BookClaim/"),
    PutNewClaim("/domgenprelive/RestAPI/BookClaim/"),
    GetQuestion("/domgenprelive/RestAPI/BookClaim/"),
    PutAnswer("/domgenprelive/RestAPI/BookClaim/"),
    GetServiceOption("/domgenprelive/RestAPI/BookClaim/"),
    PutServiceOption("/domgenprelive/RestAPI/BookClaim/"),
    PutRepairData("/domgenprelive/RestAPI/BookClaim/"),
    GetAllClaims("/domgenprelive/RestAPI/ClaimsAPI/"),
    Cancellation("/domgenprelive/RestAPI/ClaimData/Cancellation"),
    GetNewAppointments("/domgenprelive/RestAPI/ClaimData/"),
    PutNewAppointment("/domgenprelive/RestAPI/ClaimData/");


    private String resourcesURL;

    Resources(String resourcesURL) {
        this.resourcesURL = resourcesURL;
    }

    public String getResourcesURL()
    {
        return resourcesURL;
    }
}
