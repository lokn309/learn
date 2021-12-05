package lokn.springboot.jdbc.primitive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/05 16:22
 */
public class PrepareStatementSql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "lokn");
        String sql = "insert into person (id, name) values (?, ?)";
        // 开启手动提交事务
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 5; i++) {
                preparedStatement.setString(1, i + "");
                preparedStatement.setString(2, "insert" + i);
                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
            System.out.println("执行结果：" + ints.length);
            connection.commit();
            preparedStatement.addBatch();
        } catch (Exception e) {
            System.out.println("事务提交失败，执行rollback。");
            connection.rollback();
        }
    }

}
