package ApiPayloads;

public class UpdateTransactionAPI {

    public static String updateTransactionByModelNumber(String guid, String modelNumber,String channelCode)
    {
        return "{\n" +
                "  \"GUID\": \""+guid+"\",\n" +
                "  \"ModelNumber\": \""+modelNumber+"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String updateTransactionByUniqueApplianceId(String guid, String uniqueApplianceId,String channelCode)
    {
        return "{\n" +
                "  \"GUID\": \""+guid+"\",\n" +
                "  \"UniqueApplianceID\": \""+uniqueApplianceId+"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String updateTransactionByClaimType(String guid, String ClaimType, String channelCode)
    {
        return "{\n" +
                "  \"GUID\": \""+guid+"\",\n" +
                "  \"ClaimTypeID\": \""+ClaimType+"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\",\n" +
                "  \"ApplianceUseable\": \"Yes\"\n" +
                "}";
    }

    public static String updateTransactionByFaultCategoryAndFaultID(String guid, String faultCategoryID, String faultID, String channelCode )
    {
        return "{\n" +
                "  \"GUID\": \""+guid+"\",\n" +
                "  \"FaultCategoryID\": \""+faultCategoryID+"\",\n" +
                "  \"FaultID\": \""+faultID+"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\",\n" +
                "  \"ApplianceUseable\": \"Yes\"\n" +
                "}";
    }

















}
