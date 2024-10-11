package com.deezer.demo.exception;

public class MusicNotFoundException extends Exception{
    public MusicNotFoundException(String message) {
        super(message);
    }
}
