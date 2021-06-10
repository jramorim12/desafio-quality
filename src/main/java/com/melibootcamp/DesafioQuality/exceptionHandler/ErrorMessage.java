package com.melibootcamp.DesafioQuality.exceptionHandler;

import java.util.List;

public class ErrorMessage {
    private String message;
    private List<InvalidField> errors;

    public ErrorMessage(String message, List<InvalidField> errors) {
        this.message = message;
        this.errors = errors;
    }

    public ErrorMessage() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<InvalidField> getErrors() {
        return errors;
    }

    public void setErrors(List<InvalidField> errors) {
        this.errors = errors;
    }
}
