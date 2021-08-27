package com.example.demoapi.controller;

import com.example.demoapi.model.Response;
import com.example.demoapi.model.User;
import com.example.demoapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/api/user")
    public Response<User> getUser(
            @RequestHeader(required = false) String correlationId,
            @RequestParam(required = false) int id
    ) {
        if(correlationId == null || correlationId.isBlank() || id < 0) {
            return new Response<>(1999, null);
        }
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return new Response<>(1000, user.get());
        }
        return new Response<>(1001, null);
    }

    @PostMapping("api/user")
    public Response<String> addUser(
            @RequestHeader(required = false) String correlationId,
            @RequestBody(required = false) User user
    ) {
        if(correlationId == null || correlationId.isBlank() || user == null || user.getId() < 0) {
            return new Response<>(1999, null);
        }

        if(userRepo.findById(user.getId()).isPresent()) {
            return new Response<>(1002, "Duplicated id");
        }

        return new Response<>(1003, "Data will be reviewed before able to retrieve with this API");
    }
}
