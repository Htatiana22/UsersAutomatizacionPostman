package com.postman.models.UserModel;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.java.mk_latn.No;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Name {

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;
}
