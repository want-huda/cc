import com.alibaba.druid.pool.DruidDataSource;
import com.controller.StudentController;
import com.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateTest {
    public void testForJava() {

        //0.创建一个连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //1.实例化JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //2.设置数据源,调用方法
        jdbcTemplate.update("insert into student values(?,?,?,?,?)", 1, "张三", "男", 18, "一班");


    }
    @Test
    public void testForIoc(){
        //1.获取ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");

        //2.获取bean
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "delete from students where id = ?";
        jdbcTemplate.update(sql, 10);

        //3.插入数据

        sql = "insert into students values(?,?,?,?,?)";
        //参数1：sql语句 参数2：占位符的值  返回值：影响的行数
        int row = jdbcTemplate.update(sql, 10, "李四", "男", 18, "一班");
        System.out.println(row);

        //4.查询数据
         sql = "select * from students where id = ?";

        //参数1：sql语句 参数2：RowMapper 参数3 返回值：查询到的对象
        Student student = jdbcTemplate.queryForObject(sql,  (rs, rowNum) -> {
            //自己处理结果映射
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setGender(rs.getString("gender"));
            stu.setClasses(rs.getString("class"));
            return stu;
        }, 2);

        System.out.println("student = " + student);
    }
    @Test
    public void testSelect(){
        //1.获取ioc容器
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring-02.xml");

        //2.获取bean
       StudentController controller = context.getBean("controller", StudentController.class);

        //3.调用方法
        controller.select();

        //4.关闭容器
        context.close();
    }
}
