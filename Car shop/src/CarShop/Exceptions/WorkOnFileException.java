package CarShop.Exceptions;

import java.io.IOException;

public class WorkOnFileException extends IOException {

    public WorkOnFileException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
