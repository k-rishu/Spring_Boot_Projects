package com.myorg.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class UserResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
    private UserDAOService service;

    public UserResource(UserDAOService userDAOService){
        this.service = userDAOService;
    }
    @GetMapping("/users")
    public List<User> retriveAllUser(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveOneUser(@PathVariable int id){

        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id : " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//        logger.info("Received request body: " + user.toString());
        User savedUser = service.save(user);
         URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){

        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id : " + id);
        }
        service.deleteUser(user);
    }
}
