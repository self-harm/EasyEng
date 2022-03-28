package io.harmed.easyeng.model;

import io.harmed.easyeng.enums.LanguageType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private LanguageType language;

    private String name;

    private boolean isDeleted = Boolean.FALSE;
}
