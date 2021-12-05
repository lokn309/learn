package lokn.springboot.jdbc.primitive;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/05 16:38
 */
public class HikariSql {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername("root");
        config.setPassword("lokn");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        HikariDataSource dataSource = new HikariDataSource(config);
        Connection connection = dataSource.getConnection();
        String update = "update person set name = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, "hikariUpdate");
        preparedStatement.setString(2, "5");
        int i = preparedStatement.executeUpdate();
        System.out.println("执行结果为：" + i);

    }

}
