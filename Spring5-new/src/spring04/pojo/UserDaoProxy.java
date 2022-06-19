package spring04.pojo;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

//创建代理对象代码
public class UserDaoProxy implements InvocationHandler {
    private Object obj;
    //有参数构造传递需要被代理的对象
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行..."+method.getName()+"传递的参数..."
        + Arrays.toString(args));
        //执行被增强的方法
        Object res = method.invoke(obj, args);
        System.out.println("方法执行之后..."+obj);
        return res;
    }
}
