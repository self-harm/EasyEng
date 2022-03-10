package io.harmed.easyeng.service.impl;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.exception.EntityNotFoundException;
import io.harmed.easyeng.mapper.UserMapper;
import io.harmed.easyeng.model.User;
import io.harmed.easyeng.repository.UserRepository;
import io.harmed.easyeng.service.UserService;
import io.harmed.easyeng.service.security.util.RoleUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final RoleUtils roleUtils;

    @Override
    public UserDTO save(UserDTO userDTO) {
        // todo: add logging
        final var entity = mapper.toEntity(userDTO);
        roleUtils.getDefaultRole()
                .ifPresent(role -> entity.setRoles(Set.of(role)));
        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        final var entity = repository.findById(id);
        return entity.map(mapper::toDto);
    }

    @Override
    public Optional<UserDTO> findByLogin(String login) {
        final var entity = repository.findByLogin(login);
        return entity.map(mapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        final var entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        final var entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));

        final var updatedEntity = mapper.update(dto, entity);
        repository.save(updatedEntity);

        return dto;
        // todo: how update encrypted password?
    }
}