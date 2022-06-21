package spring06.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring06.pojo.UserDao;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public void accountMoney(){
        userDao.reduceMoney();
        userDao.addMoney();
    }
}
