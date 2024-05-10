package ApiPayloads;

import java.time.LocalDateTime;

public class QuestionAnswerAPI {


    public static String getQuestionAPI(String claimID, String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\",\n" +
                "    \"QuestionID\": null\n" +
                "}";
    }

    public static String putAnswerAPI(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Cheddar\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }


    public static String getQuestionID(String claimID, String questionID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\",\n" +
                "    \"QuestionID\": \""+questionID+"\"\n" +
                "}";
    }

    public static String putAnswerDatePicker(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \""+LocalDateTime.now() +"\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String putAnswerDropdown(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Cheddar\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String putAnswerResponseField(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Test\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }

    public static String putAnswerRadioButton(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Yes\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }
    public static String putAnswerList(String claimID, String questionID, String answerID,String channelCode)
    {
        return "{\n" +
                "    \"ClaimID\": \""+claimID+"\",\n" +
                "    \"QuestionID\": \""+questionID+"\",\n" +
                "    \"AnswerID\": \""+answerID+"\",\n" +
                "    \"AnswerValue\": \"Yes\",\n" +
                "    \"ChannelCode\": \""+channelCode+"\",\n" +
                "    \"CountryCode\": \"GB\"\n" +
                "}";
    }
















}
