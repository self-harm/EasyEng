package io.harmed.easyeng.mapper;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends EntityMapper<UserDTO, User> {
}