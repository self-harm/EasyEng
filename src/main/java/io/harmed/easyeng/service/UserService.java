package io.harmed.easyeng.service;

import io.harmed.easyeng.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(final UserDTO userDTO);

    Optional<UserDTO> findById(final Long id);

    Optional<UserDTO> findByLogin(final String login);

    List<UserDTO> findAll();

    UserDTO update(final Long id, final UserDTO userDTO);

    UserDTO updatePassword(
            final Long id,
            final String oldPassword,
            final String newPassword
    );
}
