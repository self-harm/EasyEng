package io.harmed.easyeng.repository;

import io.harmed.easyeng.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(final String login);
}
