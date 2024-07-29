package com.riwi.assesment.api.controllers;

import com.riwi.assesment.api.dto.request.UserRequest;
import com.riwi.assesment.api.dto.response.UserBasicResponse;
import com.riwi.assesment.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserBasicResponse> create(@Validated @RequestParam UserRequest user){
        return ResponseEntity.ok(this.userService.create(user));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserBasicResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserBasicResponse> update(@Validated @RequestBody UserRequest user,@PathVariable String id){
        return ResponseEntity.ok(this.userService.update(user,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
