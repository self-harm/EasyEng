package io.harmed.easyeng.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public record EncodedPasswordMapper(PasswordEncoder encoder) {

    @EncodedMapping
    public String encode(final String password) {
        return encoder.encode(password);
    }
}