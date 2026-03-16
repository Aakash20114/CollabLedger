package test;

import database.UserRepository;
import models.User;

public class TestUserRepository {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        User user = new User();
        user.setUsername("Aakash");
        user.setPasswordHash("123456");
        user.setRole("admin");

        repo.createUser(user);

        System.out.println("User inserted successfully");
    }
}