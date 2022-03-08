package io.harmed.easyeng.repository;

import io.harmed.easyeng.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
