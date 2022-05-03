import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDao implements Authors {
    private Connection connection;

    public AuthorsDao() {
        try {
            Config config = new Config();
            // Get the driver into our app
            DriverManager.registerDriver(new Driver());
            // Create the Connection object
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public List<Author> all() {
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors");
            while (rs.next()) {
                Author author = new Author(
                        rs.getLong("id"),
                        rs.getString("author_name")
                );
                authors.add(author);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
        return authors;
    }

    @Override
    public Author getAuthorById(long id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors WHERE id=" + id);
            rs.next();
            Author author = new Author(
                    rs.getLong("id"),
                    rs.getString("author_name")
            );
            return author;
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
    }

    @Override
    public long insert(Author author) {
        String author_name = author.getAuthor_name();
        String query = "INSERT INTO codeup_test_db.authors (author_name) VALUES ('" + author_name + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            long key = rs.getLong(1);
            return key;
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
    }
}