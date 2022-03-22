package io.harmed.easyeng.mapper;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EncodedPasswordMapper.class)
public interface UserMapper extends EntityMapper<UserDTO, User> {

    default User update(final UserDTO dto, final User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setLogin(dto.getLogin());

        return entity;
    }

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    @Override
    User toEntity(final UserDTO dto);

    @Mapping(target = "password", ignore = true)
    @Override
    UserDTO toDto(final User entity);
}