package io.harmed.easyeng.dto;

import io.harmed.easyeng.enums.LanguageType;
import lombok.Data;

@Data
public class DictionaryDTO {

    private String id;
    private String name;


    private LanguageType language;
    private String userId;
    private boolean isDeleted;
}