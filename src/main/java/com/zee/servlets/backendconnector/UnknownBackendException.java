package com.zee.servlets.backendconnector;

public class UnknownBackendException extends Exception {
    public UnknownBackendException() {
    }

    public UnknownBackendException(String message) {
        super(message);
    }
}
