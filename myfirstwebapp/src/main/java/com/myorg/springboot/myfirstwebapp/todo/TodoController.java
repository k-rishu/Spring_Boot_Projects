package com.myorg.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService todoService){
        super();
        this.todoService = todoService;
    }

    @RequestMapping("listtodos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUserName(model);

        List<Todo> todos = todoService.findByUsername(username);
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
        todoService.addTodos(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:listtodos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:listtodos";
    }
    @RequestMapping(value = "update-todo", method=RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "addTodos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "addTodos";
        }
        todoService.updateTodos(todo);
        String username = getLoggedInUserName(model);
        todo.setUsername(username);
        return "redirect:listtodos";
    }


}
