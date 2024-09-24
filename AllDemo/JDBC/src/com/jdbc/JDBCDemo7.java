package com.jdbc;

import com.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo7 {
    public static void main(String[] args) {
        // 1、导入jar包。
            // 1、复制jar文件进libs文件夹
            // 2、右键libs文件加Add as Library
        // 2、注册驱动自动注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 3、获取数据库的链接对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<empyee> empyees = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnect();
            // 4、定义一个sql语句
            String sql="SELECT\n" +
                    "    empyee.id,\n" +
                    "    ename,\n" +
                    "    jname,\n" +
                    "    description,\n" +
                    "    (select ename from empyee t2 where empyee.mgr = t2.id) mgr_name,\n" +
                    "    joindate,\n" +
                    "    salary,\n" +
                    "    bonus,\n" +
                    "    dname,\n" +
                    "    loc,\n" +
                    "    grade\n" +
                    "FROM\n" +
                    "    empyee, job,dept,salarygrade\n" +
                    "WHERE\n" +
                    "    dept_id=dept.id\n" +
                    "    AND job_id=job.id\n" +
                    "    AND dept_id=dept.id\n" +
                    "    AND salary < hisalary\n" +
                    "    AND salary > lowsalary;";

            // 5、获取执行sql对象 Statement
            statement = connection.createStatement();

            // 6、执行sql
            resultSet = statement.executeQuery(sql);
            // 7、处理结果

            /*
            public int id;
            public String ename;
            public String jname;
            public String description;
            public String mgr_name;
            public Date joindate;
            public Double salary;
            public Double bonus;
            public String dname;
            public String loc;
            public int grade;
            */
            empyee empyee = null;
            while (resultSet.next()) {
                empyee = new empyee();
                empyee.id = resultSet.getInt("id");
                empyee.ename = resultSet.getString("ename");
                empyee.jname = resultSet.getString("jname");
                empyee.description = resultSet.getString("description");
                empyee.mgr_name = resultSet.getString("mgr_name");
                empyee.joindate = resultSet.getDate("joindate");
                empyee.salary = resultSet.getDouble("salary");
                empyee.bonus = resultSet.getDouble("bonus");
                empyee.dname = resultSet.getString("dname");
                empyee.loc = resultSet.getString("loc");
                empyee.grade = resultSet.getInt("grade");
                empyees.add(empyee);
            }

            for (empyee empye : empyees) {
                System.out.println(empye);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 8、释放资源
            JDBCUtils.close(resultSet, statement, connection);

        }

    }
}
