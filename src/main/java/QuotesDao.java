import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuotesDao implements Quotes {
    private Connection connection;

    public QuotesDao() {
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
    public List<Quote> all() {
        List<Quote> quotes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.quotes");
            while (rs.next()) {
                int author_id = rs.getInt("author_id");
                Authors authorsDao = DaoFactory.getAuthorsDao();
                Author quoteAuthor = authorsDao.getAuthorById(author_id);
                Quote quote = new Quote(
                        rs.getLong("id"),
                        rs.getString("content"),
                        quoteAuthor
                );
                quotes.add(quote);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
        return quotes;
    }

    @Override
    public void insert(Quote quote) {

    }
}