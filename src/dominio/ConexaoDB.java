package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String url = "jdbc:mysql://localhost:3306/chatbot";
    private static final String user = "root";
    private static final String password = "mysql";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
