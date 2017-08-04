package dayoff.calc.data;

import dayoff.calc.model.Role;
import dayoff.calc.model.User;
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

    public Collection<User> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<User>(s.createCriteria(User.class).list()));
    }

    public List<Role> getRolesByUserid(long userId) {
        return sessionExecutor.readSession((s) ->
                s.createCriteria(Role.class).add(Restrictions.eq("userId", userId)).list());
    }

    public User getByName(String username) {
        return sessionExecutor.readSession((s) -> {
            Query query = s.createQuery("from users where username = :username ");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();

            user.setAuthorities(getRolesByUserid(user.getId()));
            return user;
        });
    }

    public User get(long id) {
        return sessionExecutor.readSession((s) -> (User) s.get(User.class, id));
    }

    public void update(User user) {
        sessionExecutor.updateSession((s) -> s.update(user));
    }

    public void save(User user) {
        sessionExecutor.updateSession((s) -> s.persist(user));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    User user = (User) s.get(User.class, id);
                    s.delete(user);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }
}
