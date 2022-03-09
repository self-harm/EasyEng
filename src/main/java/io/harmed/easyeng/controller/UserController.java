package io.harmed.easyeng.controller;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.exception.EntityNotFoundException;
import io.harmed.easyeng.model.User;
import io.harmed.easyeng.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static io.harmed.easyeng.controller.util.PageUtils.getPage;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class UserController {

    private final UserService userService;

    // todo: add logging

//    @GetMapping("/hi")
//    public String test() {
//        return "it's working";
//    }

    @GetMapping
    public Page<UserDTO> getAll(final Pageable pageable) {
        final var users = userService.findAll();
        return getPage(users, pageable);
    }

    @GetMapping("{id}")
    public UserDTO getById(@PathVariable final Long id) {
        return userService.findById(id)
                          .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id), User.class));
    }

    @PostMapping
    public UserDTO create(@RequestBody final UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping
    public UserDTO update() {
        // todo: implement
        return null;
    }
}
