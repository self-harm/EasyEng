package io.harmed.easyeng.exception;

import java.text.MessageFormat;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String id, final Class<?> clazz) {
        super(MessageFormat.format("Entity {0} with id={1} not found", clazz.getSimpleName(), id));
    }
}