package com.postman.tasks;

import com.postman.models.UserModel.UserModel;
import com.postman.questions.BuildDataUser;
import com.postman.utils.UserData;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userData = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Put.to(UserData.extractTo().get(0).get("endPoint"))
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .body(userData)
                        )
        );

    }
    public static Performable put(){
        return instrumented(PutUserTask.class);

    }
}
