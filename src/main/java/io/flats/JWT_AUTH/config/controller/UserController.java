package io.flats.JWT_AUTH.config.controller;

import io.flats.JWT_AUTH.config.exeption.NotFoundException;
import io.flats.JWT_AUTH.config.dto.UserDto;
import io.flats.JWT_AUTH.config.dto.UserDtoFactory;
import io.flats.JWT_AUTH.config.service.UserService;
import io.flats.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(UserDtoFactory.createUserDto(user));
    }
}
