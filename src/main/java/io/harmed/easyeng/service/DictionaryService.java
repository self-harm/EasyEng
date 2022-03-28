package io.harmed.easyeng.service;

import io.harmed.easyeng.dto.DictionaryDTO;

import java.util.List;

public interface DictionaryService {

    DictionaryDTO save(final DictionaryDTO dictionaryDTO);

    DictionaryDTO findById(final Long id);

    List<DictionaryDTO> findAllByUserLogin(final String login);

    List<DictionaryDTO> findAll();

    void deleteByName(final String name);

    DictionaryDTO update(final Long id, final DictionaryDTO dictionaryDTO);
}