package com.postman.questions;

import com.postman.models.UserModel.Address;
import com.postman.models.UserModel.Name;
import com.postman.models.UserModel.UserModel;
import com.postman.utils.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildDataUser implements Question <UserModel>{

    @Override
    public UserModel answeredBy(Actor actor) {
       Map<String, String> data = UserData.extractTo().get(0);

        Address address = Address.builder()
                .city("Manizales")
                .street("Colinas")
                .number(22)
                .zipcode("9022")
                .build();

        Name name = Name.builder()
                .firstname(data.get("firstName"))
                .lastname(data.get("lastName"))
                .build();

        UserModel userModel = UserModel.builder()
                .email(data.get("email"))
                .username(data.get("userName"))
                .password(data.get("password"))
                .name(name)
                .address(address)
                .phone("3181122")
                .build();

        return userModel;
    }
    public static BuildDataUser was(){
        return new BuildDataUser();
    }
}