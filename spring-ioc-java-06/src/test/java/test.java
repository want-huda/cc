import com.config.JavaConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    @Test
    public void test1(){
        //加载配置类
       ApplicationContext applicationContext
               = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        Object studentController = applicationContext.getBean("studentController");
        System.out.println("studentController = " + studentController);
        }
}
