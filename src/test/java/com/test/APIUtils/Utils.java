package com.test.APIUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification baseReq;

    public RequestSpecification requestSpecification() throws IOException {

        if (baseReq == null) {

            PrintStream logFile = new PrintStream(new FileOutputStream("logging.txt"));
            baseReq = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURI"))
                    .addFilter(RequestLoggingFilter.logRequestTo(logFile))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logFile))
                    .setContentType(ContentType.JSON)
                    .addHeader("SynergyToken", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .build();
            return baseReq;
        }
        return baseReq;
    }

    public static String getGlobalValues(String key) throws IOException {
        Properties prop = new Properties();
        try {
            FileInputStream newFile = new FileInputStream("C:/Users/56183/Documents/Manish/Automation/RestAssuredApiBasic/src/test/resources/properties/config.properties");
            prop.load(newFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key)
    {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
//        return js.get(key).toString();
        return js.getString(key);

    }





}
