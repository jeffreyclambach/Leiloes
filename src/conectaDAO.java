import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    private static final String URL = 
        "jdbc:mysql://127.0.0.1:3306/leiloes" +
        "?useSSL=false" +
        "&allowPublicKeyRetrieval=true" +
        "&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "Q1w@e3r4t5";

    public Connection connectDB() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados!");
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        new conectaDAO().connectDB();
    }
}
