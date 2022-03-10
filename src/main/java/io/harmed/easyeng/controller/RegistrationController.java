package io.harmed.easyeng.controller;

import io.harmed.easyeng.dto.UserDTO;
import io.harmed.easyeng.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "Registration", description = "The Registration API")
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Register user")
    public UserDTO create(@RequestBody final UserDTO userDTO) {
        log.debug("Create user");
        return userService.save(userDTO);
    }
}
