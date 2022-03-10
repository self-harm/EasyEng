package io.harmed.easyeng.repository;

import io.harmed.easyeng.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(final String name);
}
