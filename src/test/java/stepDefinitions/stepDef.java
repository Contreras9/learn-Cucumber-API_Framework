package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;

public class stepDef {
    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;

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

        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        res = given().spec(req)
                .body(place);
    }
    @When("User calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        response = res.when().post("/maps/api/place/add/json")
                .then().spec(resSpec).extract().response();
    }
    @Then("The API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(), 200);
    }
    @And("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        assertEquals(jsonPath.get(keyValue).toString(), expectedValue);
    }
}
