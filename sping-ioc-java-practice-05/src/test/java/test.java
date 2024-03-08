import com.config.JavaConfiguration;
import com.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    @Test
    public void test() {
        ApplicationContext applicationContext
                =new AnnotationConfigApplicationContext(JavaConfiguration.class);

        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.select();
    }
}
