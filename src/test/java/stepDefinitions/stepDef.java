package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class stepDef {

    @Given("Add Place Payload")
    public void add_place_payload() {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        AddPlace place = new AddPlace();

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        place.setLocation(l);
        place.setAccuracy(50);
        place.setName("Frontline house");
        place.setPhone_number("(+91) 983 893 3937");
        place.setAddress("29, side layout, cohen 09");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        place.setTypes(myList);
        place.setWebsite("https://rahulshettyacademy.com");
        place.setLanguage("French-IN");

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        RequestSpecification res = given().spec(req)
                .body(place);
    }
    @When("User calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in reponse body is {string}")
    public void in_reponse_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
