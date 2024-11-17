package com.test.API;

import PojoConcept.PojoClasses.CancellationRequest;
import PojoConcept.PojoClasses.GetServiceOptionRequest;
import PojoConcept.PojoClasses.putNewClaimRequest;
import PojoConcept.PojoClasses.startTransactionRequest;
import com.test.APIUtils.Utils;
import java.io.IOException;
import java.time.LocalDateTime;

public class apiBuilder {

//    DgxApiStepDefinition stepDef = new DgxApiStepDefinition();

    public byte[] startTransactionPayload(String PlanNo, String OEM, String productType) throws IOException {
        startTransactionRequest stReq = new startTransactionRequest();
        stReq.setPlanNumber(PlanNo);
        stReq.setManufacturer(OEM);
        stReq.setProductType(productType);
        stReq.setChannelCode(Utils.getGlobalValues("channelCode"));
        stReq.setCountryCode(Utils.getGlobalValues("countryCode"));
        return stReq;

    }

    public String getMandatoryDataPayload(String guid) throws IOException {
        return "{\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String getDataPayload(String guid, String searchModelNo) throws IOException {
        return "{\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"DataCategory\": \"OEMAppliances\",\n" +
                "    \"DataType\": \"ModelNumber\",\n" +
                "    \"SearchTerm\": \""+searchModelNo+"\"\n" +
                "}";
    }

    public String updateTransactionUniqueApplianceIDPayload(String guid, String uniqueApplianceID) throws IOException {
        return "{\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"UniqueApplianceID\": \""+uniqueApplianceID+"\"\n" +
                "}";
    }

    public String updateTransactionFaultCategoryIDPayload(String guid, String faultCategoryID, String faultID) throws IOException {
        return "{\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"FaultCategoryID\": \""+faultCategoryID+"\",\n" +
                "    \"FaultID\": \""+faultID+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"ApplianceUseable\": \"Yes\"\n" +
                "}";
    }

    public String updateTransactionClaimTypePayload(String guid, String claimType) throws IOException {
        return "{\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"ClaimTypeID\": \""+claimType+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"ApplianceUseable\": \"Yes\"\n" +
                "}";
    }

    public byte[] putNewClaimPayload(String guid, String firstName, String lastName) throws IOException {
        putNewClaimRequest pnc = new putNewClaimRequest();
        pnc.setGUID(guid);
        pnc.setCustomerTitle("MR");
        pnc.setClaimEmail(Utils.getGlobalValues("claimEmail"));
        pnc.setClaimMobile(Utils.getGlobalValues("claimMobile"));
        pnc.setClaimLandline(Utils.getGlobalValues("claimLandline"));
        pnc.setCustomerFirstName(firstName);
        pnc.setCustomerLastName(lastName);
        pnc.setCustomersHouseStreetName(Utils.getGlobalValues("customerAddr1"));
        pnc.setCustomersLocalArea(Utils.getGlobalValues("customerAddr2"));
        pnc.setCustomersTownCity(Utils.getGlobalValues("customerAddr3"));
        pnc.setCustomersPostCode(Utils.getGlobalValues("customerPostCode"));
        pnc.setChannelCode(Utils.getGlobalValues("channelCode"));
        pnc.setCountryCode(Utils.getGlobalValues("countryCode"));
        return pnc;
    }

    public String getQuestions(String claimID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"QuestionID\": null\n" +
                "}";
    }

    public String putAnswer(String claimID, String question, String answer) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+question+"\",\n" +
                "    \"AnswerID\": \""+answer+"\",\n" +
                "    \"AnswerValue\": \"Test\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String getNextQuestionID(String claimID, String questionID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\"\n" +
                "}";
    }

    public String putAnswerDatePicker(String claimID, String questionID, String answerID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \""+ LocalDateTime.now() +"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String putAnswerDropdown(String claimID, String questionID, String answerID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Cheddar\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String putAnswerResponseField(String claimID, String questionID, String answerID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Test\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String putAnswerRadioButton(String claimID, String questionID, String answerID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Yes\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }
    public String putAnswerList(String claimID, String questionID, String answerID) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Yes\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public byte[] getServiceOptionPayload(String claimID, String firstName, String lastName) throws IOException {
        GetServiceOptionRequest gso = new GetServiceOptionRequest();
        gso.setClaimID(claimID);
        gso.setCustomerTitle("MR");
        gso.setClaimEmail(Utils.getGlobalValues("claimEmail"));
        gso.setClaimMobile(Utils.getGlobalValues("claimMobile"));
        gso.setClaimLandline(Utils.getGlobalValues("claimLandline"));
        gso.setCustomerFirstName(firstName);
        gso.setCustomerLastName(lastName);
        gso.setCustomersHouseStreetName(Utils.getGlobalValues("customerAddr1"));
        gso.setCustomersLocalArea(Utils.getGlobalValues("customerAddr2"));
        gso.setCustomersTownCity(Utils.getGlobalValues("customerAddr3"));
        gso.setCustomersPostCode(Utils.getGlobalValues("customerPostCode"));
//        gso.setCustomersPostCode(stepDef.getPostCode());
        gso.setChannelCode(Utils.getGlobalValues("channelCode"));
        gso.setCountryCode(Utils.getGlobalValues("countryCode"));
        gso.setCustomersLocalArea("");
        return gso;
    }

    public String putServiceOptionPayload(String claimID,String serviceOptionId) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"ServiceOptionID\": \""+serviceOptionId+"\",\n" +
                "    \"ServiceOptionRequiredFields\": [],\n" +
                "    \"AvailabilityStartDate\": \"\",\n" +
                "    \"AvailabilityEndDate\": \"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public String putRepairDataPayload(String claimID, String planNo, String dateSelect, String slotSelect) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"PlanNo\": \""+planNo+"\",\n" +
                "    \"AppointmentDate\": \""+dateSelect+"\",\n" +
                "    \"AppointmentSlotIdentifier\": \""+slotSelect+"\",\n" +
                "    \"CollectionData\": null,\n" +
                "    \"ExtraInformation\": \"\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }

    public byte[] cancellationPayload(String planNo, String claimNo) throws IOException {
        CancellationRequest canReq = new CancellationRequest();
        canReq.setPlanNumber(planNo);
        canReq.setClaimID(claimNo);
        canReq.setChannelCode(Utils.getGlobalValues("channelCode"));
        canReq.setCountryCode(Utils.getGlobalValues("countryCode"));
        return canReq;
    }

    public String putNewAppointmentPayload(String claimID, String slotIdentifier ) throws IOException {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"AppointmentSlotIdentifier\": \""+slotIdentifier+"\",\n" +
                "    \"AppointmentNotes\": \"Rebook an appointment-Notes updated\",\n" +
                "    \"ChannelCode\": \""+Utils.getGlobalValues("channelCode")+"\",\n" +
                "    \"CountryCode\": \""+Utils.getGlobalValues("countryCode")+"\"\n" +
                "}";
    }



}
