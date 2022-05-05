package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getAdListerUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException sqlException) {
            throw new RuntimeException("Error connecting to the database!", sqlException);
        }
    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException sqlException) {
            throw new RuntimeException("Error retrieving all ads.", sqlException);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createInsertQuery(),
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, ad.getUserId());
            preparedStatement.setString(2, ad.getTitle());
            preparedStatement.setString(3, ad.getDescription());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next(); //next
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery() {
        return "INSERT INTO adlister_db.ads(user_id, title, description) VALUES (?, ?, ?)";
    }

    private Ad extractAd(ResultSet resultSet) throws SQLException {
        return new Ad(
                resultSet.getLong("id"),
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet resultSet) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (resultSet.next()) {
            ads.add(extractAd(resultSet));
        }
        return ads;
    }
}