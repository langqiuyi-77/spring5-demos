package spring06.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemlate;

    @Override
    public void reduceMoney() {
        String sql = "update account set money=money-? where username=?";
        jdbcTemlate.update(sql, 100, "lucy");
    }

    @Override
    public void addMoney() {
        String sql = "update account set money=money+? where username=?";
        jdbcTemlate.update(sql, 100, "mary");
    }
}
