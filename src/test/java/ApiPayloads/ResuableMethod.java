package ApiPayloads;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ResuableMethod {

    public static XmlPath rawToXML(Response r)
    {
        String respon = r.asString();
        XmlPath x = new XmlPath(respon);
        return x;
    }

    public static JsonPath rawToJSON(Response r)
    {
        String respon = r.asString();
        JsonPath x = new JsonPath(respon);
        return x;
    }











}
