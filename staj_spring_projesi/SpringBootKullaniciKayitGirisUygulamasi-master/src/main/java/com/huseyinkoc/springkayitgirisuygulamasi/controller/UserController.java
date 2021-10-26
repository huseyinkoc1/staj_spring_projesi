package com.huseyinkoc.springkayitgirisuygulamasi.controller;

import com.huseyinkoc.springkayitgirisuygulamasi.exception.RecordNotFoundException;
import com.huseyinkoc.springkayitgirisuygulamasi.model.Todo;
import com.huseyinkoc.springkayitgirisuygulamasi.model.User;
import com.huseyinkoc.springkayitgirisuygulamasi.repository.TodoDao;
import com.huseyinkoc.springkayitgirisuygulamasi.service.TodoService;
import com.huseyinkoc.springkayitgirisuygulamasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by huseyinkoc on 14.02.2019.
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TodoService todoService;

    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegisterPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);

        if (result.hasErrors()) {
            return "register";
        } else {
            userService.saveUser(user);

        }
        return "index";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        return "index";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value ="/secure")
    public String secure(Model model, @ModelAttribute Todo todo) {

        todo = new Todo();

        List<Todo> todos = (List<Todo>) todoDao.findAll();

        model.addAttribute("todoList", todos);

        return "secure";
    }


    @RequestMapping(value = "/secure", method = RequestMethod.POST)
    public String securePost(Model model, @ModelAttribute Todo todo) {
        todoDao.save(todo);

        List<Todo> todos = (List<Todo>) todoDao.findAll();

        model.addAttribute("todoList", todos);
        return "secure";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId) {

        todoDao.delete(employeeId);
        return "redirect:/secure";
    }


    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            Todo entity = todoService.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new Todo());
        }
        return "update";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(Todo employee)
    {
        todoService.createOrUpdateEmployee(employee);
        return "redirect:/secure";
    }
}
