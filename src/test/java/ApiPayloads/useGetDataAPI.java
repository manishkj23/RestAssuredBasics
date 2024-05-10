package ApiPayloads;

public class useGetDataAPI {

    public static String useGetDataByModel(String guid, String modelNumber)
    {
        return "{\n" +
                "    \"ChannelCode\": \"AAT\",\n" +
                "    \"CountryCode\": \"GB\",\n" +
                "    \"GUID\": \""+guid+"\",\n" +
                "    \"DataCategory\": \"OEMAppliances\",\n" +
                "    \"DataType\": \"ModelNumber\",\n" +
                "    \"SearchTerm\": \""+modelNumber+"\"\n" +
                "}";
    }









}
