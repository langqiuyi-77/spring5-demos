package spring02.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void update() {
        System.out.println("userDao update");
    }
}
