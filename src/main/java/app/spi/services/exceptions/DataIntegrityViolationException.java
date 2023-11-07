package app.spi.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class DataIntegrityViolationException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}