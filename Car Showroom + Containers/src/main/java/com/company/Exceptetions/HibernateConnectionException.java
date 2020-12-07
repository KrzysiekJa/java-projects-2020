package com.company.Exceptetions;

public class HibernateConnectionException extends RuntimeException{
    public HibernateConnectionException(String message) {
        super(message);
    }
}
