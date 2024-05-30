package com.test.APIUtils;

public enum Resources {

    //Enum is a special class in Java which has collections of constant or methods

    StartTransaction("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    GetMandatoryData("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    GetData("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    UpdateTransaction("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    PutNewClaim("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    GetQuestion("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    PutAnswer("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    GetServiceOption("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    PutServiceOption("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    PutRepairData("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/BookClaim/"),
    GetAllClaims("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/ClaimsAPI/"),
    Cancellation("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/ClaimData/Cancellation"),
    GetNewAppointments("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/ClaimData/"),
    PutNewAppointment("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/ClaimData/"),
    GetRepairData("/domgen"+Utils.getGlobalValues("env")+"/RestAPI/ClaimData/");

    private String resourcesURL;

    Resources(String resourcesURL)
    {
        this.resourcesURL = resourcesURL;
    }

    public String getResourcesURL()
    {
        return resourcesURL;
    }










}
