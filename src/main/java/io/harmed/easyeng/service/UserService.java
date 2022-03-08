package io.harmed.easyeng.service;

import io.harmed.easyeng.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO save(final UserDTO userDTO);

    List<UserDTO> saveAll(final List<UserDTO> userDTOs);
}
