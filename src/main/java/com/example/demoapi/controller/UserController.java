package com.example.demoapi.controller;

import com.example.demoapi.model.ResponseModel;
import com.example.demoapi.model.User;
import com.example.demoapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/api/users")
    public ResponseModel<List<User>> getAllUsers() {
        return new ResponseModel<>(1000, userRepo.findAll());
    }

    @GetMapping("/api/user")
    public ResponseModel<User> getUser(
            @RequestHeader(required = false) String correlationId,
            @RequestParam(required = false) int id
    ) {
        if(correlationId == null || correlationId.isBlank() || id < 0) {
            return new ResponseModel<>(1999, null);
        }
        return new ResponseModel<>(1000, userRepo.findById(id));
    }

    @PostMapping("api/user")
    public ResponseModel<String> addUser(
            @RequestHeader(required = false) String correlationId,
            @RequestBody(required = false) User user
    ) {
        if(correlationId == null || correlationId.isBlank() || user == null || user.getId() < 0) {
            return new ResponseModel<>(1999, null);
        }

        if(userRepo.findById(user.getId()) != null) {
            return new ResponseModel<>(3001, "Duplicated id");
        }

        return new ResponseModel<>(3002, "Data will be reviewed before able to retrieve with this API");
    }
}
