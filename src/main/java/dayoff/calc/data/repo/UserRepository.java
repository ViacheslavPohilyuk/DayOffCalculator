package dayoff.calc.data.repo;

import dayoff.calc.data.SessionExecutor;
import dayoff.calc.model.User;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 28.07.17.
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<User>(s.createCriteria(User.class).list()));
    }

    public List<String> getUsernames() {
        return sessionExecutor.readSession((s) -> new ArrayList<String>(s.createCriteria(User.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("username"))).list()));
    }

    public User getByName(String username) {
        return sessionExecutor.readSession((s) ->
                (User) s.createQuery("from User where username = :username")
                        .setParameter("username", username)
                        .uniqueResult());
    }

    public User get(long id) {
        return sessionExecutor.readSession((s) -> {
            User user = (User) s.get(User.class, id);
            user.setAuthorities(roleRepository.getRolesByUserId(user.getId()));
            return user;
        });
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
