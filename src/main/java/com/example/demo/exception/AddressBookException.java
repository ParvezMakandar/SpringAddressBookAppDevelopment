package com.example.demo.exception;
public class AddressBookException extends RuntimeException{
    public AddressBookException(String message) {
        super(message);
    }
}