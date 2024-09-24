package DataSource.jdbctemplate;

import DataSource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JDBCTemplateMain {
    public static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
//    public static void main(String[] args) {
//
////        method1(jdbcTemplate);
//
////        method2(jdbcTemplate);
//
////        method3(jdbcTemplate);
//
////        method4(jdbcTemplate);
//
////        method5(jdbcTemplate);
//
////        method6(jdbcTemplate);
//
////        method7(jdbcTemplate);
//
//        method8(jdbcTemplate);
//    }

    @Test
    public void method8() {
        String sql = "SELECT COUNT(id) id FROM empyee";
//        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }

    @Test
    public void method7() {
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

        // 3、调用方法
//        List<empyee> query = jdbcTemplate.query(sql, new RowMapper<empyee>() {
//            @Override
//            public empyee mapRow(ResultSet resultSet, int i) throws SQLException {
//                empyee empyee = new empyee();
//                empyee.id = resultSet.getInt("id");
//                empyee.ename = resultSet.getString("ename");
//                empyee.jname = resultSet.getString("jname");
//                empyee.description = resultSet.getString("description");
//                empyee.mgr_name = resultSet.getString("mgr_name");
//                empyee.joindate = resultSet.getDate("joindate");
//                empyee.salary = resultSet.getDouble("salary");
//                empyee.bonus = resultSet.getDouble("bonus");
//                empyee.dname = resultSet.getString("dname");
//                empyee.loc = resultSet.getString("loc");
//                empyee.grade = resultSet.getInt("grade");
//                return empyee;
//            }
//        });

        List<empyee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<empyee>(empyee.class));
        System.out.println(query);
    }

    @Test
    public void method6() {
        String sql = "SELECT * FROM empyee";

        // 3、调用方法
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void method5() {
        String sql = "SELECT * FROM empyee WHERE id=1001";

        // 3、调用方法
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        System.out.println(stringObjectMap);
    }

    @Test
    public void method4() {
        String sql = "DELETE FROM empyee WHERE id=1015";
        // 3、调用方法
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }


    @Test
    public void method3() {
        String sql = "INSERT INTO empyee (id, ename, job_id, mgr, joindate, salary, bonus, dept_id) VALUES\n" +
                "(?, ?, ?, ?, ?,? , ?, ?);";
        // 3、调用方法
        int update = jdbcTemplate.update(sql,1015, "赵云", 4, 1007, "2001-06-23","160000.00", null, 10);
        System.out.println(update);
    }

    @Test
    public void method2() {
        System.out.println("请输入工资金额并以回车键结束:");
        Scanner scanner = new Scanner(System.in);
        String salary = scanner.next();
        String sql="UPDATE empyee SET salary=? WHERE  id IS NOT NULL LIMIT 1;";

        // 3、调用方法
        int update = jdbcTemplate.update(sql, salary);
        System.out.println(update);
    }

    @Test
    public void method1() {
        System.out.println("请输入用户名并以回车键结束:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.println("请输入金额并以回车键结束");
        String balance = scanner.next();

        ResultSet resultSet = null;

        // 1、导入jar包
        // 2、创建JDBCTemplate对象


        String sql="INSERT INTO account (name, balance) VALUES (?, ?);";

        // 3、调用方法
        int update = jdbcTemplate.update(sql, username, balance);
        System.out.println(update);
    }
}
