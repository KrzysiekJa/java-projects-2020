package com.company.Spot;

public class NoSolutionException extends IllegalArgumentException{
    private final String str;

    public NoSolutionException(String str) {
        this.str = str;
    }
}
