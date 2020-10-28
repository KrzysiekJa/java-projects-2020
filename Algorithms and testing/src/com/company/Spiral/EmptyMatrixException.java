package com.company.Spiral;

public class EmptyMatrixException extends IllegalArgumentException{
    private final String str;

    public EmptyMatrixException(String str) {
        this.str = str;
    }
}
