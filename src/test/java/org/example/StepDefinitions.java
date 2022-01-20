package org.example;

import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions implements En {

    private static final String BASE_URL = "https://api.zippopotam.us";
    private String country;
    private String zipCode;
    private static Response response;
    private static String jsonString;

    public StepDefinitions() {
        Given("the country code {string} and zip code {string}", (String country, String zipCode) -> {
            this.country = country;
            this.zipCode = zipCode;
        });

        When("I request the locations corresponding to these codes", () -> {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            response = request.get("/" + this.country + "/" + this.zipCode);
            jsonString = response.asString();

        });

        Then("the response contains the place name {string}", (String placeName) -> {
            List<Map<String, String>> places = JsonPath.from(jsonString).get("places");
            Assert.assertTrue("number of places = " + places.size() ,places.size() > 0);
            List<String> realPlaceNames = JsonPath.from(jsonString).get("places.'place name'");
            Assert.assertTrue("place name length= " + realPlaceNames.size() ,realPlaceNames.size() > 0);
            assertThat(realPlaceNames, hasItem(placeName));
        });

        Then("the response contains the state {string}", (String stateName) -> {
            List<Map<String, String>> places = JsonPath.from(jsonString).get("places");
            Assert.assertTrue("number of places = " + places.size() ,places.size() > 0);
            List<String> states = JsonPath.from(jsonString).get("places.state");
            assertThat(states, hasItem(stateName));
        });

        Then("the response contains exactly '{int}' location(s)", (Integer numberOfLocations) -> {
            List<Map<String, String>> places = JsonPath.from(jsonString).get("places");
            Assert.assertEquals("number of places = " + places.size(), places.size(), (int) numberOfLocations);
        });

        Then("the response has status code '{int}'", (Integer statusCode) -> {
            Assert.assertEquals("status code = " + response.statusCode(), response.statusCode(), (int) statusCode);

        });

    }
}
