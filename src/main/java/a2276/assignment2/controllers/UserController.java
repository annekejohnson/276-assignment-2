package a2276.assignment2.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import a2276.assignment2.models.User;
import a2276.assignment2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {  
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @GetMapping("/users/showAll")
    public String showAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        int newHeight = Integer.parseInt(newuser.get("height"));
        int newWeight = Integer.parseInt(newuser.get("weight"));
        String newHair = newuser.get("hair colour");
        float newGPA = Float.parseFloat(newuser.get("gpa"));
        userRepo.save(new User(newName,newHeight,newWeight,newHair,newGPA));
        response.setStatus(201);
        return "redirect:/users/view";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        System.out.println("DELETE user");
        userRepo.deleteById(Integer.parseInt(id));
        return "redirect:/users/view";
    }

    @GetMapping("/users/details/{id}")
    public String detailsPage(@PathVariable String id, Model model) {
        System.out.println("VIEW user");
        List<User> toView = userRepo.findByUid(Integer.parseInt(id));
        model.addAttribute("us", toView);
        return "users/details";
    }

    @PostMapping("/users/edit/{id}")
    public String editor(@PathVariable String id, @RequestParam Map<String, String> editUser, HttpServletResponse response){
        List<User> student = userRepo.findByUid(Integer.parseInt(id));
        User toEdit = student.get(0);
        toEdit.setName(editUser.get("name"));
        toEdit.setHeight(Integer.parseInt(editUser.get("height")));
        toEdit.setWeight(Integer.parseInt(editUser.get("weight")));
        toEdit.setHair(editUser.get("hair colour"));
        toEdit.setGPA(Float.parseFloat(editUser.get("gpa")));
        userRepo.save(toEdit);
        return "redirect:/users/view";
    }
    
}