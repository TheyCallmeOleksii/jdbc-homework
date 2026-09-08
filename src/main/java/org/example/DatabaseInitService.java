import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String sqlFilePath = "sql/init_db.sql";

        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));

            Connection connection = Database.getInstance().getConnection();

            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
                System.out.println("Базу даних успішно ініціалізовано! Таблиці створено.");
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Помилка виконання SQL запиту: " + e.getMessage());
        }
    }
}