package jdbcdemo;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo {
    @Test
    public void testPostgres() throws ClassNotFoundException, SQLException {
        Driver driver = new org.postgresql.Driver();
        Class.forName("org.postgresql.Driver");

        // Соединение с БД
        String userName = "postgres";
        String password = "123";
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", userName, password);
        // Создаём SQL-оператор
        Statement query = con.createStatement();
        // Создаем таблицу
        query.execute("DROP TABLE IF EXISTS \"user\";");
        query.execute("DROP SEQUENCE IF EXISTS \"user_id_seq\";");
        query.execute("CREATE SEQUENCE user_id_seq START 101;");
        query.execute("CREATE TABLE \"user\" (" +
                "  id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('user_id_seq'::regclass)," +
                "  name CHARACTER VARYING(1024)" +
                ");");
        query.execute("INSERT INTO \"user\"(name) VALUES('Петя');");
        query.execute("INSERT INTO \"user\"(name) VALUES('Вася');");
        query.execute("INSERT INTO \"user\"(name) VALUES('Женя');");

        // Получаем результаты
        ResultSet resultSet = query.executeQuery("SELECT * FROM \"user\" ORDER BY NAME");
        while (resultSet.next()) { // Пока есть результаты
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();

        resultSet = query.executeQuery("SELECT * FROM \"user\" ORDER BY NAME");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + " = " + resultSet.getString(i) + " ");
            }
            System.out.println();
        }
        resultSet.close();
    }
}
