package spring02.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public void add() {
        System.out.println("service add...............");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao.toString() +
                '}';
    }
}
