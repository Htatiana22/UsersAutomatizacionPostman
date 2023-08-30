package com.postman.stepDefinitions;

import com.postman.questions.DeleteDataResponse;
import com.postman.tasks.DeleteUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserStepDefinition {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("User");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    @When("The user consumes the endpoint and sends the id to delete the user")
    public void theUserConsumesTheEndpointAndSendsTheIdToDeleteTheUser() {
        user.attemptsTo(
                        DeleteUserTask.delete()
                );
    }
    @Then("The valid user with the phone in the reply message")
    public void theValidUserWithThePhoneInTheReplyMessage() {
        String delete = DeleteDataResponse.was().answeredBy(user).getPhone();
        user.should(
        seeThat(
        "The response is",
        response -> DeleteDataResponse.was().answeredBy(user).getPhone(),
        equalTo("1-570-236-7033"))
        );
    }
}
