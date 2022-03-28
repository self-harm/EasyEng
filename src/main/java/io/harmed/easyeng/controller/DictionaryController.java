package io.harmed.easyeng.controller;

import io.harmed.easyeng.dto.DictionaryDTO;
import io.harmed.easyeng.service.DictionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.harmed.easyeng.controller.util.PageUtils.getPage;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "Dictionary", description = "The Dictionary API")
@RequestMapping("/dictionary")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @PostMapping
    @Operation(summary = "Save dictionary")
    public DictionaryDTO create(@RequestBody final DictionaryDTO dictionaryDTO) {
        log.debug("Create dictionary");
        return dictionaryService.save(dictionaryDTO);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get dictionary by id")
    public DictionaryDTO getById(@PathVariable final Long id) {
        log.debug("Get dictionary by id, id: {}", id);
        return dictionaryService.findById(id);
    }

    @GetMapping("login/{login}")
    @Operation(summary = "Get dictionary by user login")
    public List<DictionaryDTO> getAllByUserLogin(@PathVariable final String login) {
        log.debug("Get all dictionaries by user login, login: {}", login);
        return dictionaryService.findAllByUserLogin(login);
    }

    @GetMapping
    @Operation(summary = "Get all dictionaries")
    public Page<DictionaryDTO> getAll(final Pageable pageable) {
        log.debug("Get all dictionaries, page: {}", pageable);
        final var dictionaries = dictionaryService.findAll();
        return getPage(dictionaries, pageable);
    }

    @DeleteMapping("{name}")
    @Operation(summary = "Soft delete dictionary by name")
    public ResponseEntity<String> deleteByName(@PathVariable final String name) {
        log.debug("Delete dictionary by name, name: {}", name);
        dictionaryService.deleteByName(name);
        return new ResponseEntity<>(
                String.format("%s dictionary has been deleted", name),
                HttpStatus.OK
        );
    }
}