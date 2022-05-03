import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    private static List<String> getAuthorNames() {
        List<String> authorNames = new ArrayList<>();

        try {
            Config config = new Config();
            //reusing this over&over
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
                    //reusing this over&over
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT author_name FROM codeup_test_db.authors");
            while (resultSet.next()) {
                authorNames.add(resultSet.getString("author_name"));
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
        return authorNames;
    }

    public static void main(String[] args) {
        List<String> authorNames = getAuthorNames();
        for (String name : authorNames) {
            System.out.println(name);
        }
    }
}
