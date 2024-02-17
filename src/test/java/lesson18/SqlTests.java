package lesson18;

import lombok.SneakyThrows;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlTests {
    Connection connection;
    Statement statement;
    @SneakyThrows
    @BeforeTest
    public void connect(){
        connection = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?" +
                "user=testqa07&password=testqa07");
        statement = connection.createStatement();
    }
    @SneakyThrows
    @Test(priority = 1)
    public void firstAdditionTest(){
        statement.executeUpdate("INSERT INTO user (last_name, id, first_name, age) " +
                "VALUES ('Niko', 105, 'Oluy', 24)");
        print("SELECT * FROM user WHERE last_name = 'Niko'");
    }
    @SneakyThrows
    @Test(priority = 2)
    public void secondAdditionTest(){
        statement.executeUpdate("INSERT INTO user (last_name, id, age) " +
                "VALUES ('Misha', 106, null)");
        print("SELECT * FROM user WHERE last_name = 'Misha'");
    }
    @Test(priority = 3)
    public void firstSelectTest(){
        print("SELECT * FROM user");
    }
    @Test(priority = 4)
    public void secondSelectTest(){
        print("SELECT * FROM user WHERE last_name LIKE 't%'");
    }
    @Test(priority = 5)
    public void thirdSelectTest(){
        print("SELECT DISTINCT * FROM user WHERE id BETWEEN 15 AND 150 ORDER BY age DESC");
    }
    @SneakyThrows
    @Test(priority = 6)
    public void firstUpdateTest(){
        statement.executeUpdate("UPDATE user SET first_name = 'Sun' WHERE last_name = 'Misha'");
        print("SELECT * FROM user WHERE last_name = 'Misha'");
    }
    @SneakyThrows
    @Test(priority = 7)
    public void secondUpdateTest(){
        statement.executeUpdate("UPDATE user SET age = 32 WHERE last_name = 'Misha'");
        print("SELECT * FROM user WHERE last_name = 'Misha'");
    }
    @SneakyThrows
    @Test(priority = 8)
    public void firstDeleteTest(){
        statement.executeUpdate("DELETE FROM user WHERE last_name = 'Misha'");
    }
    @SneakyThrows
    @Test(priority = 9)
    public void secondDeleteTest(){
        statement.executeUpdate("DELETE FROM user WHERE last_name = 'Niko'");
        print("SELECT * FROM user");
    }
    @SneakyThrows
    @AfterTest
    public void closeConnection(){
        statement.close();
    }
    @SneakyThrows
    public List<Map<String, String>> print(String query) {
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData data = resultSet.getMetaData();
        List<Map<String, String>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> result = new HashMap<>();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                result.put(data.getColumnName(i), resultSet.getString(i));
            }
            table.add(result);
        }
        System.out.println(query);
        table.forEach(System.out::println);
        System.out.println("\n");
        return table;
    }
}
