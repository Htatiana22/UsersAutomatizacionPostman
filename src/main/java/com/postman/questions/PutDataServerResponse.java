package com.postman.questions;

import com.postman.models.UserModel.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PutDataServerResponse implements Question <UserModel> {
    @Override
    public UserModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModel.class);
    }

    public static PutDataServerResponse was(){
        return new PutDataServerResponse();
    }
}
