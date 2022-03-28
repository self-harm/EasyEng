package io.harmed.easyeng.exception;

import java.util.List;
import java.util.stream.Collectors;

public class EnumValueNotValidException extends RuntimeException {

    public <T> EnumValueNotValidException(final String illegalEnumValue, final List<T> enumValuesRange) {
        super(String.format(
                "Value %s does not present in the valid range: %s",
                illegalEnumValue,
                enumValuesRange.stream().map(T::toString).collect(Collectors.joining(", "))
        ));
    }
}