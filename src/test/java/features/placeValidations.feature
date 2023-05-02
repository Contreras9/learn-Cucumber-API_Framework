Feature: Validating Place APIs

  Scenario: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload
    When User calls AddPlaceAPI with POST http request
    Then The API call got success with status code 200
    And Status in response body is OK