package org.example.server;

import java.sql.*;
import java.sql.PreparedStatement;

public class DBManager {
    private Connection connection = null;
    private Statement statement;

    public DBManager() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/org/example/resources/sqlite_db.s3db");
            if (connection != null) {
                System.out.println("Соединение установлено!");
                statement = connection.createStatement();
                addRecords();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Error!");
        }
    }

    private void addRecords() {
        try {

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public String getNickByLoginAndPass(String login, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("select nickname from users where login=\"" + login + "\" and password=\"" + password + "\"");
            statement.setString(1, login);
            statement.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeNick(String oldNick, String newNick) {
        try {
            statement.executeUpdate("update 'users' set nickname=\""+newNick+"\" where nickname=\""+oldNick+"\"");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
