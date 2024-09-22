package com.example.userregistration.Services;


import org.springframework.web.multipart.MultipartFile;

import com.example.userregistration.dao.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    // Method to save the user data and process the file
    User saveUserData(String userId, String collegeEmailId, String collegeRollNumber,
                      String dataString, MultipartFile file) throws IOException;

    // Method to retrieve all users (for example, for admin access)
    List<User> getAllUsers();

    // Method to retrieve a user by their ID
    User getUserById(Long id);

    // Method to delete a user by their ID
    void deleteUserById(Long id);
}
