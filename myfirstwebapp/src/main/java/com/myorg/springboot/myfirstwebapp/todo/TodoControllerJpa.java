package com.myorg.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private TodoService todoService;
    private TodoRepository todoRepository;
    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository){
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUserName(model);

        List<Todo> todos = todoRepository.findByUsername(username);
        System.out.println("here I am....");

        model.addAttribute("todos", todos);
        return "todos";
    }

    private static String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUserName(model);
        Todo todo = new Todo(0, username, "", LocalDate.now(), false);
//        model.put("todo", todo);
        model.addAttribute("todo", todo);
        return "addTodos";
    }

//    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
//    public String showNewTodoPage(){
//        return "addTodos";
//    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "addTodos";
        }
        String username = getLoggedInUserName(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodos(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id){
//        todoService.deleteById(id);
        todoRepository.deleteById(id);
        return "redirect:list-todos";

    }
    @RequestMapping(value = "update-todo", method=RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
//        Todo todo = todoService.findById(id);
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "addTodos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()) {
            return "addTodos";
        }
        String username = getLoggedInUserName(model);
        todo.setUsername(username);
//        todoService.updateTodos(todo);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }


}
