package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getAdListerUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to the database! line 18", sqle);
        }
    }

    public boolean usernameExist(String username) {
        try {
            String query = "SELECT * FROM users WHERE username=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("error, ling 32, ", sqle);
        }
        return false;
    }

    public boolean emailExist(String email) {
        try {
            String query = "SELECT * FROM users WHERE email=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("line 47", sqle);
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return extractUser(resultSet);
            } else return null;
        } catch (SQLException sqle) {
            throw new RuntimeException("line 63", sqle);
        }
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException sqle) {
            throw new RuntimeException("error line 89, ", sqle);
        }
    }
}

