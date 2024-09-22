package com.example.userregistration.Services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.userregistration.dao.User;
import com.example.userregistration.repo.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserData(String userId, String collegeEmailId, String collegeRollNumber,
                             String dataString, MultipartFile file) throws IOException {

        User user = new User();
        user.setUserId(userId);
        user.setCollegeEmailId(collegeEmailId);
        user.setCollegeRollNumber(collegeRollNumber);

        // Extract numbers and alphabets from the data string
        String numbers = dataString.replaceAll("[^0-9]", "");
        String alphabets = dataString.replaceAll("[^a-zA-Z]", "");
        user.setNumbersArray(Arrays.toString(numbers.split("")));
        user.setAlphabetsArray(Arrays.toString(alphabets.split("")));

        // Find the highest lowercase alphabet
        Optional<Character> highestLowercase = dataString.chars()
                .filter(Character::isLowerCase)
                .mapToObj(c -> (char) c)
                .max(Character::compareTo);

        highestLowercase.ifPresent(ch -> user.setHighestLowercase(String.valueOf(ch)));

        // Process file details
        if (file != null && !file.isEmpty()) {
            user.setFileValid(true);
            user.setFileMimeType(file.getContentType());
            user.setFileSizeKB(file.getSize() / 1024); // File size in KB
        } else {
            user.setFileValid(false);
            user.setFileMimeType(null);
            user.setFileSizeKB(0);
        }

        // Save the user entity to the database
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
