package ru.netology.qai.javaforqai.hw14.task1.services;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
