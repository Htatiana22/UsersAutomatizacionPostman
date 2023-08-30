package com.postman.stepDefinitions;

import com.postman.questions.ServerResponse;
import com.postman.tasks.PostUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostUserStepDefinition {
    private EnvironmentVariables environmentVariables;

    private String theRestApiBaseUrl;
    Actor user= Actor.named("User");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    @When("The user consumes the endpoint and sends the information of the email,userName,password,firstName,lastName")
    public void theUserConsumesTheEndpointAndSendsTheInformationOfTheEmailUserNamePasswordFirstNameLastName() {
        user.attemptsTo(
                PostUserTask.post()
        );
    }
    @Then("the user can validate the response service {int}")
    public void theUserCanValidateTheResponseService(Integer resServer) {
        user.should(
                seeThat(
                     "The response code is: ",
                        ServerResponse.was(),
                        equalTo(resServer)

                )
        );

    }
}
