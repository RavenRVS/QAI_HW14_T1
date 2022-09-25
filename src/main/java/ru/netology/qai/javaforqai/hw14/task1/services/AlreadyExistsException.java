package ru.netology.qai.javaforqai.hw14.task1.services;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
