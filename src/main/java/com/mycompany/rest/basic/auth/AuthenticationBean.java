package com.mycompany.rest.basic.auth;

public class AuthenticationBean {

    public String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message = %s]",this.message);
    }
}
