import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String sqlFilePath = "sql/find_max_projects_client.sql";
        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            Connection connection = Database.getInstance().getConnection();
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    int count = rs.getInt("PROJECT_COUNT");
                    result.add(new MaxProjectCountClient(name, count));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String sqlFilePath = "sql/find_longest_project.sql";
        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            Connection connection = Database.getInstance().getConnection();
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    int monthCount = rs.getInt("MONTH_COUNT");
                    result.add(new LongestProject(name, monthCount));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String sqlFilePath = "sql/find_max_salary_worker.sql";
        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            Connection connection = Database.getInstance().getConnection();
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    int salary = rs.getInt("SALARY");
                    result.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> result = new ArrayList<>();
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            Connection connection = Database.getInstance().getConnection();
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()) {
                    String type = rs.getString("TYPE");
                    String name = rs.getString("NAME");
                    LocalDate birthday = LocalDate.parse(rs.getString("BIRTHDAY"));
                    result.add(new YoungestEldestWorker(type, name, birthday));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        String sqlFilePath = "sql/print_project_prices.sql";

        try {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            Connection connection = Database.getInstance().getConnection();

            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                while (rs.next()) {
                    String name = rs.getString("NAME");
                    int price = rs.getInt("PRICE");

                    result.add(new ProjectPrice(name, price));
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println("--- Клієнти з найбільшою кількістю проєктів ---");
        for (MaxProjectCountClient client : queryService.findMaxProjectsClient()) {
            System.out.println(client);
        }

        System.out.println("\n--- Найдовший(і) проєкт(и) ---");
        for (LongestProject project : queryService.findLongestProject()) {
            System.out.println(project);
        }

        System.out.println("\n--- Працівник(и) з найбільшою зарплатою ---");
        for (MaxSalaryWorker worker : queryService.findMaxSalaryWorker()) {
            System.out.println(worker);
        }

        System.out.println("\n--- Наймолодший та найстарший працівники ---");
        for (YoungestEldestWorker worker : queryService.findYoungestEldestWorkers()) {
            System.out.println(worker);
        }

        System.out.println("\n--- Вартість проєктів ---");
        for (ProjectPrice projectPrice : queryService.printProjectPrices()) {
            System.out.println(projectPrice);
        }
    }
}