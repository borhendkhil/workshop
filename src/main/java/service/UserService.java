package service;

import entity.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();


    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email, password, role) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getRole() + "')";
        try(Connection connection = DatabaseConnection.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = '" + user.getName() + "', email = '" + user.getEmail() + "', password = '" + user.getPassword() + "', role = '" + user.getRole() + "' WHERE id = " + user.getId();
        try (Connection connection = DatabaseConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = DatabaseConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
