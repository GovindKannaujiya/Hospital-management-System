package hospital.management.system;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class conn {

    Connection connection;
    Statement statement;

    public conn() {
        try {
            Properties props = new Properties();

            // Loads DB credentials from db.properties (kept out of Git via .gitignore).
            // Copy db.properties.example -> db.properties and fill in your own values.
            try (InputStream input = new FileInputStream("db.properties")) {
                props.load(input);
            }

            String url = props.getProperty("db.url", "jdbc:mysql://localhost:3306/hospital_management_system");
            String user = props.getProperty("db.user", "root");
            String password = props.getProperty("db.password", "");

            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
