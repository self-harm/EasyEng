package io.harmed.easyeng.service.impl;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.exception.EntityNotFoundException;
import io.harmed.easyeng.exception.WrongOldPasswordException;
import io.harmed.easyeng.mapper.UserMapper;
import io.harmed.easyeng.model.User;
import io.harmed.easyeng.repository.UserRepository;
import io.harmed.easyeng.service.UserService;
import io.harmed.easyeng.service.security.util.RoleUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final RoleUtils roleUtils;
    private final PasswordEncoder encoder;

    @Override
    public UserDTO save(final UserDTO dto) {
        // todo: add logging
        final var entity = mapper.toEntity(dto);
        roleUtils.getDefaultRole()
                .ifPresent(role -> entity.setRoles(Set.of(role)));
        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    public Optional<UserDTO> findById(final Long id) {
        final var entity = repository.findById(id);
        return entity.map(mapper::toDto);
    }

    @Override
    public Optional<UserDTO> findByLogin(final String login) {
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
    public UserDTO update(final Long id, final UserDTO dto) {
        final var entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));

        final var updatedEntity = mapper.update(dto, entity);
        repository.save(updatedEntity);

        return dto;
    }

    public UserDTO updatePassword(
            Long id,
            final String oldPassword,
            final String newPassword
    ) {
        final var entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));

        final boolean isEqual = encoder.matches(oldPassword, entity.getPassword());

        if (!isEqual) {
            throw new WrongOldPasswordException(String.valueOf(entity.getId()));
        }

        entity.setPassword(encoder.encode(newPassword));
        repository.save(entity);

        return mapper.toDto(entity);
    }
}