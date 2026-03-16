package services;

import database.UserRepository;
import models.User;
import utils.PasswordUtil;
import org.bson.Document;

public class AuthService {


private UserRepository userRepository;

public AuthService() {
    userRepository = new UserRepository();
}

// Register user
public void registerUser(String username, String password) {

    String hashedPassword = PasswordUtil.hashPassword(password);

    User user = new User();
    user.setUsername(username);
    user.setPasswordHash(hashedPassword);
    user.setRole("user");

    userRepository.createUser(user);

    System.out.println("User registered successfully.");
}

// Login user
public boolean loginUser(String username, String password) {

    Document userDoc = userRepository.findUserByUsername(username);

    if (userDoc == null) {

        System.out.println("User not found.");
        return false;
    }

    String storedPassword = userDoc.getString("passwordHash");

    String hashedPassword = PasswordUtil.hashPassword(password);

    if (storedPassword.equals(hashedPassword)) {

        System.out.println("Login successful.");
        return true;

    } else {

        System.out.println("Invalid password.");
        return false;
    }
}


}
