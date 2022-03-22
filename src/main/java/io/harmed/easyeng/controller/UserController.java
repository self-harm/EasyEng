package io.harmed.easyeng.controller;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.exception.EntityNotFoundException;
import io.harmed.easyeng.model.User;
import io.harmed.easyeng.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static io.harmed.easyeng.controller.util.PageUtils.getPage;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "User", description = "The User API")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public Page<UserDTO> getAll(final Pageable pageable) {
        log.debug("Get all users, page: {}", pageable);
        final var users = userService.findAll();
        return getPage(users, pageable);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get user by id")
    public UserDTO getById(@PathVariable final Long id) {
        log.debug("Get user by id, id: {}", id);
        return userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));
    }

    @PutMapping("{id}")
    @Operation(summary = "Update user")
    public UserDTO update(@PathVariable final Long id, @RequestBody final UserDTO userDTO) {
        log.debug("Update user by id, id: {}", id);
        return userService.update(id, userDTO);
    }

    @PutMapping("/{id}/password")
    @Operation(summary = "Update user password")
    public UserDTO updatePassword(
            @PathVariable final Long id,
            final String oldPassword,
            final String newPassword) {
        return userService.updatePassword(id, oldPassword, newPassword);
    }
}
