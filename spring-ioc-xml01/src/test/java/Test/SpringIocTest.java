package Test;

import com.ioc_03.Happy;
import com.ioc_04.JavaBean1;
import com.ioc_05.JavaBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc容器创建和读取组件
 */

public class SpringIocTest {
    /**
     * 创建ioc读取配置文件
     */
    @Test
    public void creatIoc(){
        /*
        接口
        BeanFactory


        ApplicantContext
        实现类
        ClassPathXmlApplicationContext
        FileSystemXmlApplicationContext
        AnnotationConfigApplicationContext
        WebApplicationContext
         */

        //方式1 构造函数（String 配置文件 一个或多个）[推荐]
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2 先创建ioc对象，在指定配置文件 在进行刷新
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();

        applicationContext1.setConfigLocations("spring-03.xml");

        applicationContext1.refresh();
    }
    @Test
    public void getBeanFromIoc(){
        //创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();
        //读取
        //方案一  强转
        Happy happy = (Happy) applicationContext.getBean("happy");

        //方案二  指定类
        Happy happy1 = applicationContext.getBean("happy",Happy.class);

        //方案三  指定类型获取
        //根据bean类型获取 ，用一个类只能处在一个bean ， 如果存在多个bean会爆出不唯一异常
        //ioc的配置一定是实现类但可以根据接口取值
        Happy happy2 = applicationContext.getBean(Happy.class);
        happy1.doWork();

    }
    @Test
    public void test4(){
        //创建ioc容器  -> init
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        //正常结束ioc容器
        applicationContext.close();

    }

    @Test
    public void test5(){
        //创建ioc容器  ->
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean1 javaBean = applicationContext.getBean(JavaBean1.class);

        JavaBean1 javaBean1 = applicationContext.getBean(JavaBean1.class);

        System.out.println(javaBean1==javaBean);

        //正常结束ioc容器
        applicationContext.close();
    }

    @Test
    public void test6(){
        //创建ioc容器  ->
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-05.xml");

        JavaBean javaBean = applicationContext.getBean("javaBeanFactory",JavaBean.class);

        System.out.println("javaBeanFactory"+javaBean);
        //javaBeanFactory也会加入到ioc容器名字 &
        Object bean = applicationContext.getBean("&javaBeanFactory");
        System.out.println(bean);


        //正常结束ioc容器
        applicationContext.close();
    }
}
