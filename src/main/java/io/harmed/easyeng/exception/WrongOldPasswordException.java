package io.harmed.easyeng.exception;

import java.text.MessageFormat;

public class WrongOldPasswordException extends RuntimeException{

    public WrongOldPasswordException(final String id) {
        super(MessageFormat.format("Old password doesn't match, user id: {0}", id));
    }
}