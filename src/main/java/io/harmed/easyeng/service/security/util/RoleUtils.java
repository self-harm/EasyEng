package io.harmed.easyeng.service.security.util;

import io.harmed.easyeng.model.Role;
import io.harmed.easyeng.repository.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record RoleUtils(RoleRepository repository) {

    public Optional<Role> getDefaultRole() {
        return repository.findByName("DEFAULT");
    }

    public Optional<Role> getSystemRole() {
        return repository.findByName("SYSTEM");
    }
}
