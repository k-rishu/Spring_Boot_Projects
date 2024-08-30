package com.myOrg.rest.webservices.restfulwebservices.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoResourse {
    private TodoService todoService;

    public TodoResourse(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> retriveTodos(@PathVariable String username){
         return todoService.findByUsername(username);
    }
}
