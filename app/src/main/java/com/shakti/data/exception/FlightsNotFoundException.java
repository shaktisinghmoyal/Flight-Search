
package com.shakti.data.exception;

/**
 * Exception throw by the application when a Book search can't return a valid result.
 */
public class FlightsNotFoundException extends Exception {
    private final String Tag = "BookNotFoundException";
    public FlightsNotFoundException() {
        super();
    }

    public FlightsNotFoundException(final String message) {
        super(message);
    }

    public FlightsNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FlightsNotFoundException(final Throwable cause) {
        super(cause);
    }
}
