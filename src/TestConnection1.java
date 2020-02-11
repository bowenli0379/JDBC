import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection1 {
    public static void main(String[] args) throws SQLException{
        //1 加载驱动

        DriverManager.registerDriver(new Driver());

        //2、获取连接

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","wen950123");

        System.out.println("连接成功");

        //3、执行增删改查
        //3-1。执行sql语句
        String sql = "delete from stuinfo where stuid = 1";

        //3-2.获取执行sql语句的命令对象
        Statement statement = connection.createStatement();

        //3-3 使用命令对象指向sql语句
        int update = statement.executeUpdate(sql);

        //3-4 处理执行结果
        System.out.println(update>0 ? "success" : "fail");

        //4. 关闭连接
        statement.close();
        connection.close();
    }
}










