package com.olsproject.onlinelotterysystem.error;

public class CannotRegister extends Exception{

    public CannotRegister() {
        super();
    }

    public CannotRegister(String message) {
        super(message);
    }

    public CannotRegister(String message, Throwable cause) {
        super(message, cause);
    }
}
