package io.harmed.easyeng.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

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
}
