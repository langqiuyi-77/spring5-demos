package spring02;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring02.pojo.UserService;
import spring02.pojo.UserService1;

public class SpringTest {

    /**
     * 任务1: 使用注解创建对象
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring02/bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 任务2: 使用Autowired属性注入自动装配
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring02/bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.toString());
    }

    /**
     * 任务2: 使用Qualifier根据名称进行注入
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring02/bean2.xml");
        UserService1 userService = context.getBean("userService1", UserService1.class);
        System.out.println(userService.toString());
    }
}
