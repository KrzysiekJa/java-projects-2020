package com.company.FindThree;

public class EmptyTableException extends IllegalArgumentException{
    private final String str;

    public EmptyTableException(String str) {
        this.str = str;
    }
}
