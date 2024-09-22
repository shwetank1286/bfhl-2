package com.example.userregistration.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.userregistration.Services.UserService;
import com.example.userregistration.dao.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Show the user registration form
    @GetMapping("/form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm"; // JSP page name
    }

    // Process user data and file upload
    @PostMapping("/process")
    public String processUserData(
            User user,
            @RequestParam("data") 
            String dataString,
            @RequestParam(value = "file", required = false) 
            MultipartFile file,
            Model model) {

        try {
            // Save user data using the service
            User savedUser = userService.saveUserData(
                    user.getUserId(),
                    user.getCollegeEmailId(),
                    user.getCollegeRollNumber(),
                    dataString,
                    file
            );

            // Prepare the model attributes to send to the JSP
            model.addAttribute("status", "success");
            model.addAttribute("user", savedUser);
            model.addAttribute("fileValid", savedUser.isFileValid());
            model.addAttribute("fileMimeType", savedUser.getFileMimeType());
            model.addAttribute("fileSizeKB", savedUser.getFileSizeKB());

            return "userResult"; // JSP page for displaying the result

        } catch (IOException e) {
            model.addAttribute("error", "Error processing file: " + e.getMessage());
            return "error"; // Error page JSP
        }
    }

    // Get all users
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList"; // JSP page for displaying the user list
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id, Model model) {
        try {
            userService.deleteUserById(id);
            model.addAttribute("message", "User deleted successfully.");
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "userList"; // Redirect to user list page
    }

    // Get operation code
    @GetMapping("/operation-code")
    public String getOperationCode(Model model) {
        model.addAttribute("operation_code", "OP12345");
        return "operationCode"; // JSP page for displaying the operation code
    }
}
