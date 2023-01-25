package pl.zsbd.kucd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zsbd.kucd.dto.UserDTO;
import pl.zsbd.kucd.mapper.UserMapper;
import pl.zsbd.kucd.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/createUser")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO){
        userService.save(userMapper.toEntity(userDTO));
        return ResponseEntity.ok().build();
    }

}
