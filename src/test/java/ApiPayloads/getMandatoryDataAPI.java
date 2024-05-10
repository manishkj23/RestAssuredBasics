package ApiPayloads;

public class getMandatoryDataAPI {

    public static String getMandatoryDataAPI(String guid, String channelCode)
    {
        return "{\n" +
                "  \"GUID\": \""+guid+"\",\n" +
                "  \"ChannelCode\": \""+channelCode+"\",\n" +
                "  \"CountryCode\": \"GB\"\n" +
                "}";
    }






}
