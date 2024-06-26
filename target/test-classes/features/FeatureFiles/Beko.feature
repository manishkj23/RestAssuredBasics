Feature: Claim creation via DGX API for BEKO OEM

  @DGXAPI
  Scenario Outline: Verify users can create a claim and book an appointment for BEKO plan via DGX API

    #GetAllClaims
    Given GetAllClaim Payload with "<PlanNo>"
    When User calls "GetAllClaims" API with "GET" method
    Then I verify API call is success with status code 200
    And "Response.ResponseCode" in response body is "SC0001"
    Then I verify the Open claim is present for "<PlanNo>"

    #StartTransaction
    Given StartTransaction Payload with "<PlanNo>" "<OEM>" "<ProductType>"
    When User calls "StartTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "ST000"
    Then I verify "GUID" created after triggered the Start Transaction API

    #GetMandatoryData
    Given GetMandatoryData Payload with "GUID"
    When User calls "GetMandatoryData" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GM000"
    Then I get UniqueApplianceID, ModelNo, FaultCategory, FaultID, ClaimType for "<OEM>"

    #GetData
    And I verify if UniqueApplianceID is null and update "<searchModel>" with "GetData"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID" and "UniqueAppliance"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"
    And I get the Post Code of the "<PlanNo>"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID" and "ClaimType"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID","FaultCategoryID","FaultID"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"

    #PutNewClaim
    Given PutNewClaim Payload with "GUID","FirstName","LastName"
    When User calls "PutNewClaim" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "NC000"
    And I verify new claimID created successfully via PutNewClaim API

    #GetQuestion & PutAnswer
    Given GetQuestion Payload with "claimID"
    When User calls "GetQuestion" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GQ000"
    Then I verify the questionID & answerID gets generated

    Given PutAnswer Payload with "claimID" "questionID" "answerID"
    When User calls "PutAnswer" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "PA000"
    Then I verify nextQuestionID gets generated and status is not accepted
    And I complete the Question Answer Tree

    #GetServiceOption
    Given GetServiceOption Payload with "ClaimID" "Firstname" "LastName"
    When User calls "GetServiceOption" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GS000"
    And I verify list of Service Option displayed

    #PutServiceOption
    Given PutServiceOption Payload with "ClaimID" "ServiceOption"
    When User calls "PutServiceOption" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "PS000"
    And I get date and slot from the response for the "<OEM>"

    #PutRepairData
    Given PutRepairData Payload with "ClaimID" "<PlanNo>" "DateSelect" "SlotSelect"
    When User calls "PutRepairData" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "RD000"


    Examples:
      | PlanNo     | OEM  | ProductType     | searchModel    |
      | 6QT9002104 | BEKO | WASHING MACHINE | BEKO DV 5531 G |
#      | 6QT9001611 | BEKO | WASHING MACHINE | BEKO DD WME8227B |
#      | 6QT9000784 | BEKO | WASHING MACHINE | BEKO DD WME8227B |
#      | 6QT9000784 | BEKO | WASHING MACHINE | BEKO DD WME8227B |
#      | 6QT9000784 | BEKO | WASHING MACHINE | BEKO DD WME8227B |

#=========================== Rebook an appointment with BEKO =====================

  @DGXAPI
  Scenario Outline: Verify users can create a claim and rebook an appointment for BEKO plan via DGX API

    #GetAllClaims
    Given GetAllClaim Payload with "<PlanNo>"
    When User calls "GetAllClaims" API with "GET" method
    Then I verify API call is success with status code 200
    And "Response.ResponseCode" in response body is "SC0001"
    Then I verify the Open claim is present for "<PlanNo>"

    #StartTransaction
    Given StartTransaction Payload with "<PlanNo>" "<OEM>" "<ProductType>"
    When User calls "StartTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "ST001"
    Then I verify "GUID" created after triggered the Start Transaction API

    #GetMandatoryData
    Given GetMandatoryData Payload with "GUID"
    When User calls "GetMandatoryData" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GM000"
    Then I get UniqueApplianceID, ModelNo, FaultCategory, FaultID, ClaimType for "<OEM>"

    #GetData
    And I verify if UniqueApplianceID is null and update "<searchModel>" with "GetData"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID" and "UniqueAppliance"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"
    And I get the Post Code of the "<PlanNo>"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID" and "ClaimType"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"

    #UpdateTransaction
    Given UpdateTransaction Payload with "GUID","FaultCategoryID","FaultID"
    When User calls "UpdateTransaction" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "UT000"

    #PutNewClaim
    Given PutNewClaim Payload with "GUID","FirstName","LastName"
    When User calls "PutNewClaim" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "NC000"
    And I verify new claimID created successfully via PutNewClaim API

    #GetQuestion & PutAnswer
    Given GetQuestion Payload with "claimID"
    When User calls "GetQuestion" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GQ000"
    Then I verify the questionID & answerID gets generated

    Given PutAnswer Payload with "claimID" "questionID" "answerID"
    When User calls "PutAnswer" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "PA000"
    Then I verify nextQuestionID gets generated and status is not accepted
    And I complete the Question Answer Tree

    #GetServiceOption
    Given GetServiceOption Payload with "ClaimID" "Firstname" "LastName"
    When User calls "GetServiceOption" API with "GET" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "GS000"
    And I verify list of Service Option displayed

    #PutServiceOption
    Given PutServiceOption Payload with "ClaimID" "ServiceOption"
    When User calls "PutServiceOption" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "PS000"
    And I get date and slot from the response for the "<OEM>"

    #PutRepairData
    Given PutRepairData Payload with "ClaimID" "<PlanNo>" "DateSelect" "SlotSelect"
    When User calls "PutRepairData" API with "PUT" method
    Then I verify API call is success with status code 200
    And "Status" in response body is "OK"
    And "StatusCode" in response body is "RD000"

    #GetNewAppointments
    Given GetNewAppointments Payload with "ClaimNo"
    When User calls "GetNewAppointments" API with "GET" method
    Then I verify API call is success with status code 200
    And "StatusCode" in response body is "GN000"
    And I verify the current appointment date and new date and slot for "<OEM>"

    #PutNewAppointment
    Given PutNewAppointment Payload with ClaimNo & SlotIdentifier
    When User calls "PutNewAppointment" API with "PUT" method
    Then I verify API call is success with status code 200
    And "StatusCode" in response body is "PN000"
    Then I verify "<PlanNo>" ClaimNo is same after rebooked an appointment


    Examples:
      | PlanNo     | OEM  | ProductType     | searchModel    |
      | 6QT9002930 | BEKO | WASHING MACHINE | BEKO DV 5531 G |