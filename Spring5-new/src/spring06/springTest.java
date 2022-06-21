package spring06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring06.pojo.TxConfig;
import spring06.pojo.UserService;

public class springTest {
    /**
     * 任务1：事务的处理使用注解完成
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring06/bean06.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    /**
     * 任务2：事务处理使用xml
     */

    /**
     * 任务3：完全注解声明式事务管理
     */
    @Test
    public void test03(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
