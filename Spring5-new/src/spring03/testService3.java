package spring03;

import spring03.pojo.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testService3 {
    @Test
    public void test(){
        //加载配置类
        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService",
                UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
