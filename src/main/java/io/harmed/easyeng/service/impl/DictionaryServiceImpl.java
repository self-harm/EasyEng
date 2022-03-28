package io.harmed.easyeng.service.impl;

import io.harmed.easyeng.dto.DictionaryDTO;
import io.harmed.easyeng.exception.EntityNotFoundException;
import io.harmed.easyeng.mapper.DictionaryMapper;
import io.harmed.easyeng.model.Dictionary;
import io.harmed.easyeng.model.User;
import io.harmed.easyeng.repository.DictionaryRepository;
import io.harmed.easyeng.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository repository;
    private final DictionaryMapper mapper;

    @Override
    public DictionaryDTO save(final DictionaryDTO dictionaryDTO) {
        log.debug("Request to save dictionary");
        final var dictionary = mapper.toEntity(dictionaryDTO);
        repository.save(dictionary);
        return mapper.toDto(dictionary);
    }

    @Override
    public DictionaryDTO findById(final Long id) {
        log.debug("Request to find dictionary by id, id: {}", id);
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), Dictionary.class));
    }

    @Override
    public List<DictionaryDTO> findAllByUserLogin(final String login) {
        log.debug("Request to find all dictionaries by user login, login: {}", login);
        return repository.findByUserLogin(login).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<DictionaryDTO> findAll() {
        log.debug("Request to find all dictionaries");
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public void deleteByName(final String name) {
        log.debug("Request to delete dictionary by name, name: {}", name);
        repository.deleteByName(name);
    }

    @Override
    public DictionaryDTO update(final Long id, final DictionaryDTO dictionaryDTO) {
        log.debug("Request to update dictionary by id, id: {}", id);
        final var dictionary = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));

        dictionary.setName(dictionaryDTO.getName());
        dictionary.setLanguage(dictionaryDTO.getLanguage());

        repository.save(dictionary);
        return mapper.toDto(dictionary);
    }
}