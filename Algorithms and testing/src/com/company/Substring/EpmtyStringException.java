package com.company.Substring;

public class EpmtyStringException extends IllegalArgumentException{
    private final String str;

    public EpmtyStringException(String str) {
        this.str = str;
    }
}
