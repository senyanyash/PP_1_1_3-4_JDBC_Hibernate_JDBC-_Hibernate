package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Chris", "Joss", (byte) 45);
        userService.saveUser("Carl", "Johnson", (byte) 24);
        userService.saveUser("Denis", "Petrov", (byte) 34);
        userService.saveUser("Ivan", "Papaev", (byte) 63);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
