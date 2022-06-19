package spring02.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "userService1")
public class UserService1 {
    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    public void add() {
        System.out.println("service add...............");
    }

    @Override
    public String toString() {
        return "UserService1{" +
                "userDao=" + userDao.toString() +
                '}';
    }
}
