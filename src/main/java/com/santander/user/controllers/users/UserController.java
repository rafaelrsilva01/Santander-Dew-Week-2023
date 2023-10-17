package com.santander.user.controllers.users;

import com.santander.user.models.users.User;
import com.santander.user.services.UserService;
import org.apache.coyote.Response;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){

        userService.createUser(user);
        return ResponseEntity.ok().build();

    }
    @GetMapping
    public ResponseEntity<List<User>> listaUser(){
        return  ResponseEntity.ok(userService.listUser());
    }
    @GetMapping("{id}")
    public ResponseEntity<User> listUser(@PathVariable Long id){

        return ResponseEntity.ok(userService.findOneUser(id));
    }
}
