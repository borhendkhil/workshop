package com.example.demo;

import entity.Workspace;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.WorkspaceService;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try(Connection connection = DatabaseConnection.connect()) {
           welcomeText.setText("Database connection successful!");


        } catch (SQLException e) {
            welcomeText.setText("Database connection failed!");

        }


    }
}