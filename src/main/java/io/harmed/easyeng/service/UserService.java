package io.harmed.easyeng.service;

import io.harmed.easyeng.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(final UserDTO userDTO);

    Optional<UserDTO> findById(final Long id);

    List<UserDTO> findAll();

    UserDTO update(final Long id, final UserDTO userDTO);
}
