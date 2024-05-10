package ApiPayloads;

public class PutRepairDataAPI {

    public static String putRepairData(String claimID, String planNo, String dateSelect, String slotSelect, String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"PlanNo\": \""+planNo+"\",\n" +
                "    \"AppointmentDate\": \""+dateSelect+"\",\n" +
                "    \"AppointmentSlotIdentifier\": \""+slotSelect+"\",\n" +
                "    \"CollectionData\": null,\n" +
                "    \"ExtraInformation\": \"\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }





}
