package com.company.Exceptetions;

import java.io.IOException;

public class WorkOnFileException extends IOException {
    public WorkOnFileException(String message) {
        super(message);
    }
}
