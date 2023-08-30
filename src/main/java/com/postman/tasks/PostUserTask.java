package com.postman.tasks;

import com.postman.models.UserModel.UserModel;
import com.postman.questions.BuildDataUser;
import com.postman.utils.UserData;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userData = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Post.to(UserData.extractTo().get(0).get("endPoint"))
                        .with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userData)
                )
        );

    }
    public static PostUserTask post(){
        return instrumented(PostUserTask.class);
    }
}
