// exemplo: src/util/conectaDAO.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/leiloes?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";            // altere se necessário
    private static final String PASSWORD = "Q1w@e3r4t5";   // coloque sua senha

    public Connection getConnection() {
        try {
            // garante driver disponível (em versões modernas pode ser opcional, mas seguro)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver JDBC não encontrado. Adicione o connector JAR no projeto.", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
