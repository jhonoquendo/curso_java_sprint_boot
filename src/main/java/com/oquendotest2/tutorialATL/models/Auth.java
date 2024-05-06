package com.oquendotest2.tutorialATL.models;
import lombok.Getter;
import lombok.Setter;

public class Auth {

    public Auth(String token) {
        this.token = token;
    }

    @Getter
    @Setter
    private String token;
}
