package com.myorg.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;



@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCounts = 0;

    static{
        todos.add(new Todo(++todoCounts, "rishu","Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCounts, "rishu","Learn DevOps", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCounts, "rishu","Learn FullStack", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCounts, "rishu","Learn Azure", LocalDate.now().plusYears(1), false));
    }

    public static List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodos(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCounts, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodos(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
