import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDao implements Authors {
    private Connection connection;

    public AuthorsDao() {
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (
                SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    @Override
    public List<Author> all() {
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM codeup_test_db.authors");
            while (resultSet.next()) {
                Author author = new Author(
                        resultSet.getLong("id"),
                        resultSet.getString("author_name")
                );
                authors.add(author);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException("error connecting to db", sqlE);
        }
        return authors;
    }

    @Override
    public void insert(Author author) {

    }
}
