package controllers;

import services.AuthService;

public class AuthController {


private AuthService authService;

public AuthController() {
    authService = new AuthService();
}

// Register
public void register(String username, String password) {

    authService.registerUser(username, password);
}

// Login
public boolean login(String username, String password) {

    return authService.loginUser(username, password);
}


}
