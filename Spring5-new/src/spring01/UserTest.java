package spring01;


import spring01.pojo.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//基于xml装配
public class UserTest {

    /**
     * 任务一：实现对对象的创建
     */
    @Test
    public void add() {
        //1. 加载Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取配置创建的对象 name是spring配置中的id 是普通bean因为返回的和创建的类相同
        User user = context.getBean("user", User.class);
        user.add();
    }

    /**
     * 任务二：对对象进行依赖注入
     */
    @Test
    public void test2(){
        //1.加载spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2.获取到对象
        User user1 = context.getBean("user1", User.class);
        System.out.println(user1.toString());
    }

    /**
     * 任务三：对对象进行有参构造器构造
     */
    @Test
    public void test3(){
        //1. 加载spring核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 取得对应的bean对象
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2.toString());
    }

    /**
     * 任务四：使用p名称空间注入
     */
    @Test
    public void test4(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        User user3 = context.getBean("user3", User.class);
        System.out.println(user3.toString());
    }

    /**
     * 任务五：xml注入其他属性null和特殊符号
     */
    @Test
    public void test5(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        User user3 = context.getBean("user4", User.class);
        System.out.println(user3.toString());
    }

    /**
     * 任务六：外部bean
     */
    @Test
    public void test6(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 任务七：内部bean
     */
    @Test
    public void test7(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp.toString());
    }

    /**
     * 任务八：级联赋值的使用
     */
    @Test
    public void test8(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Emp emp = context.getBean("emp1", Emp.class);
        System.out.println(emp.toString());
    }

    /**
     * 任务九：注入集合属性
     */
    @Test
    public void test9(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu.toString());
    }

    /**
     * 任务十：list对象
     */
    @Test
    public void test10(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Stu stu = context.getBean("stu1", Stu.class);
        for (Course course: stu.getCourseList()) {
            System.out.println(course.toString());
        }
    }

    /**
     * 任务十一：提取注入
     */
    @Test
    public void test11(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Stu stu = context.getBean("stu2", Stu.class);
        for (String course: stu.getList()) {
            System.out.println(course);
        }
    }

    /**
     * 任务十二：工厂bean
     */
    @Test
    public void test12(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean.toString());
    }

    /**
     * 任务十三：bean作用域
     */
    @Test
    public void test13(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获取对应的bean对象-单实例
        UserService us1 = context.getBean("userService", UserService.class);
        UserService us2 = context.getBean("userService", UserService.class);
        System.out.println(us1);
        System.out.println(us2);
        //3. 多实例
        UserService userService1 = context.getBean("userService1", UserService.class);
        UserService userService2 = context.getBean("userService1", UserService.class);
        System.out.println(userService1);
        System.out.println(userService2);
    }

    /**
     * 任务十四：bean顺序
     */
    @Test
    public void test14(){
        //1. 加载spring的核心配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01/bean1.xml");
        //2. 获得对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建 bean 实例对象");
        //3. 想要看见实例的销毁方法需要手动进行销毁不然看不见
        context.close();
    }
}