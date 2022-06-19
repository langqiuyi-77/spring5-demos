package spring01.pojo;

public class UserService {
    //创建UserDao属性，生成set方法进行依赖注入
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add...............");
        userDao.update();
    }
}
