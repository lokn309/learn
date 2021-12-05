package lokn.springboot.jdbc.primitive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/05 15:10
 */
public class NativeSql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "lokn");
        Statement statement = connection.createStatement();
        //String sql = "insert into person (id, name) values ('3', '李四')";
        String update = "update person set name = 'update' where id = '3'";
        int execute = statement.executeUpdate(update);
        System.out.println("执行结果为：" + execute);
        statement.close();
        connection.close();
    }

}
