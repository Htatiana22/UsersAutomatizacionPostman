package com.postman.tasks;

import com.postman.utils.DeleteData;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(DeleteData.extractTo().get(0).get("endPoint") + "/" + DeleteData.extractTo().get(0).get("id"))
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                        )
        );

    }
    public static DeleteUserTask delete (){
        return instrumented(DeleteUserTask.class);

    }
}
