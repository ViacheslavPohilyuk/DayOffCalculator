package dayoff.calc.data;

import dayoff.calc.model.Role;
import dayoff.calc.model.Account;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mac on 28.07.17.
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<Account> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<Account>(s.createCriteria(Account.class).list()));
    }

    public List<Role> getRolesByUserid(long userId) {
        return sessionExecutor.readSession((s) ->
                s.createCriteria(Role.class).add(Restrictions.eq("userId", userId)).list());
    }

    public Account getByName(String username) {
        return sessionExecutor.readSession((s) -> {
            Query query = s.createQuery("from users where username = :username ");
            query.setParameter("username", username);
            Account account = (Account) query.uniqueResult();

            account.setAuthorities(getRolesByUserid(account.getId()));
            return account;
        });
    }

    public Account get(long id) {
        return sessionExecutor.readSession((s) -> (Account) s.get(Account.class, id));
    }

    public void update(Account account) {
        sessionExecutor.updateSession((s) -> s.update(account));
    }

    public void save(Account account) {
        sessionExecutor.updateSession((s) -> s.persist(account));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    Account account = (Account) s.get(Account.class, id);
                    s.delete(account);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }
}
