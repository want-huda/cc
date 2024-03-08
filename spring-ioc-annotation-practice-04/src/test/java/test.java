import com.controller.StudentController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        // 1.加载spring配置文件
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring.xml");
        // 2.获取配置创建的对象
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.select();


        // 3.调用方法
    }
}
