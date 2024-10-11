package com.deezer.demo.exception;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(String message) {
        super(message);
    }
}

