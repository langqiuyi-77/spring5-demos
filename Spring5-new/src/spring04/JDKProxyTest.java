package spring04;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring04.pojo.*;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
    /**
     * 任务1: 创建JDK动态代理代码
     * 使用的类UserDao/UserDaoProxy/UserDaoImpl
     * @param args
     */
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        System.out.println("result="+add);
    }

    /**
     * 任务2: 使用Aspectj进行AOP操作
     * 使用的类User/UserProxy
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring04/bean4.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    /**
     * 任务3: 使用Aspectj进行完全注解开发
     * 使用的类User/UserProxy/ConfigAop
     */
    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}
