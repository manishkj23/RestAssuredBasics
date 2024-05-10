package PojoConcept.PojoClasses;

import com.fasterxml.jackson.annotation.JsonGetter;

public class startTransactionResponse {

    private String GUID;
    private String Status;
    private String StatusCode;

    @JsonGetter("GUID")
    public String getGUID() {
        return GUID;
    }

    public void setGUID(String guid) {
        this.GUID = guid;
    }

    @JsonGetter("Status")
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    @JsonGetter("StatusCode")
    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }




}
