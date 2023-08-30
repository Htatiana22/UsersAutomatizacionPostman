package com.postman.stepDefinitions;

import com.postman.questions.PutDataServerResponse;
import com.postman.tasks.PutUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;


public class PutUserStepDefinition {
    private EnvironmentVariables environmentVariables;

    private String theRestApiBaseUrl;
    Actor user= Actor.named("User");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    @When("The user consumes the endpoint and updates the data of the: email, userName, password, firstName, lastName")
    public void theUserConsumesTheEndpointAndUpdatesTheDataOfTheEmailUserNamePasswordFirstNameLastName() {
        user.attemptsTo(
                PutUserTask.put()
        );
    }
    @Then("The user can validate if the update was successful with the response service userName")
    public void theUserCanValidateIfTheUpdateWasSuccessfulWithTheResponseServiceUserName() {

        String Put = PutDataServerResponse.was().answeredBy(user).getUsername();
        user.should(
             seeThat(
                   "The response from the server is",
                  response-> PutDataServerResponse.was().answeredBy(user).getUsername(),
               equalTo("htrp9022")
             ));
    }
}
