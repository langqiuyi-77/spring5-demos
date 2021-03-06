bean1.xml这是一个简单的Spring的demo，是使用xml进行配置的

1. 使用xml进行对Spring进行配置
2. Spring本身就是一个容器对所有对象进行管理
   属性正常的类对象 -> spring配置的书写实现对对象的管理(bean管理) —> 使用Spring对对象进行管理
                    -xml方式                                          -1. 加载spring的核心配置文件(位置是基于src文件下的路径才能找到)
                    -注解方式                   -对象创建               -2. 从容器中得到对象
                                               -属性注入
3. Spring的构建bean对象的是调用的对象的无参构造器，所以如果自己写了有参构造器，要加上无参构造去哦
4. Spring的注入方法
    4.1 依赖注入：是使用的set方法，set方法要存在
    4.2 有参构造器注入：
    4.3 p名称注入：
        -1. 在spring核心配置文件头加上p的名称空间，但是p名称空间不用写xsi:schemaLocation只用写xmlns:p
        -2. 使用p:属性名=“xxx”设置
        -？ 问题：p名称空间的话是怎么实现注入的呢？

5. 级联赋值
    5.1 级联赋值就像是外部bean但是在注入的那里对里面的属性进行修改
    5.2 级联赋值要求被注入的要有注入对象的get方法，即使注入对象要修改的属性没有get方法也可以
6. 对注入操作的提取
    6.1 引入util名称空间，要写写xsi:schemaLocation还有写xmlns:util
    6.2 ref引入
7. 工厂bean
    7.1 工厂bean是创建一个类implements FactoryBean<要返回的实际类型>
    7.2 实现public 要返回的实际类型 getObject() throws Exception {等3个方法。重点是getObject方法
    7.3 书写bean方法，创建对应的工厂bean
    7.4 在实现中getBean的方法传的是”要返回的实际类型.Class“: 要返回的实际类型 myBean = context.getBean("myBean", 要返回的实际类型.class);
8. bean的作用域（多实例还是单实例）
    8.1 在Spring中默认是单实例，就是从spring中获得的bean对象不论getBean多少次都是同一个对象
    8.2 可以实在scope="prototype"设置成为多实例

9. bean的生命周期
    第一步 执行无参构造创建bean实例
    第二步 调用set方法设置属性值
    在初始化之前执行的方法【后置处理器】
    第三步 执行初始化方法
    在初始化之后执行的方法【后置处理器】
    第四步 获取创建 bean 实例对象
    第五步 执行销毁的方法
    1. init方法和destroy方法都是在bean中指定的方法
    2. 要想看见destroy方要手动关闭spring才能看见
    3. 后置处理器只要配置了就是整体的后置处理器，对此spring所有bean都会调用此方法
    4. 创建后置处理器implements BeanPostProcessor 并且实现两个方法
    5. 注意是在set之后才会初始化对象

11. 在spring配置文件中引入外部属性文件
    11.1 在核心配置文件中引入context名称空间 写xsi:schemaLocation和写xmlns:context
    11.2 引入外部属性文件,location是以src为基础
    11.3 对应配置datasource的话,配置文件不要写uername而要写其他的,因为我尝试了我这个username总是HP可能在核心配置文件中就已经有了个username的东西
    
---------------------------------------------------------------------------------------
bean2.xlm-spring02 实现的是注解实现配置
1. 创建对象
    1.1 在核心配置上引入context名称空间
    1.2 开启组件开启
    1.3 在对应类上写上注解
    1.4 测试的使用调用的方法也是和xml相同加载配置文件然后getBean其实我觉得本质上就是注解相当于bean id和属性注入的一些方法的一种简便的替换

2. Autowried装配
    2.1 Autowried只是单纯的用来装配,但是还是要是有@Component等等先对对象进行创建才能有所谓的装配

3. @Qualifer根据名称进行注入一定要和@Autowired一起使用不需要set方法
4. @Resource可以根据类型注入也可以根据名称注入@Resource(name = "userDaoImpl1")  //根据名称进行注入
5. @Value：注入普通类型属性 @Value(value = "abc")

---------------------------------------------------------------------------------------
spring03: 完全注解开发
1. 创建配置类:使用两个注解表示是配置类和开启自动扫描
2. //加载配置类ApplicationContext context
                   = new AnnotationConfigApplicationContext(SpringConfig.class);
3. 使用getBean获得对象

---------------------------------------------------------------------------------------
spring04: AOP注解
1. 动态代理
    1.1 书写要被代理的对象
    1.2 创建代理对象的类
        -可以使用有参构造或者set方法设置属性存储要被代理的对象
        -实现implements InvocationHandler
        -实现invoke方法
    1.3 运用的话是使用的Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao))

2. 使用Aspectj来进行注解操作
    1. 配置文件上开启注解扫描和创建代理对象
    2. 创建类和增强类
    3. 使用注解创建类和增强类在增强类上面加一个代理对象的注解
    4. 在增强类的方法上使用@Before等注解表名在方法的什么地方上增强,使用express表达式看是对谁进行增强
    5. 使用的时候就是正常的加载配置任何getBean直接get被代理的bean就好不需要再proxy来获得了,直接获得的就是被代理好的

---------------------------------------------------------------------------------------
spring05: Aop使用xml配置
重点看bean5.xml

---------------------------------------------------------------------------------------
spring06：事务管理

1. 使用声明式注解事务管理
   1. 核心配置文件加入名称空间tx->创建事务管理器->开启事务注解
   2. 在使用的方法或者类上面加入事务注解
   3. 此注解还有一些参数可以设置事务传播行为，事务隔离，超时时间，是否只读，回滚，不回滚
2. 事务操作【未进行】
3. 完全注解配置：看TxConfig
   1. 在原本的基础上加上@EnableTransactionManagement 
   2. 创建datasource，jdbcTemplate和事务管理器对象

---



