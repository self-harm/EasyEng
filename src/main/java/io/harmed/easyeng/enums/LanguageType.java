package io.harmed.easyeng.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.harmed.easyeng.exception.EnumValueNotValidException;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public enum LanguageType {
    English("English"),
    Polish("Polish");

    private final String name;

    @JsonValue
    @Override
    public String toString() {
        return name;
    }

    @JsonCreator
    public static LanguageType fromValue(final String language) {
        final LanguageType[] values = LanguageType.values();
        return Arrays.stream(values)
                .filter(v -> v.name.equalsIgnoreCase(language))
                .findAny()
                .orElseThrow(() -> new EnumValueNotValidException(
                        language,
                        List.of(values)
                ));
    }
}
