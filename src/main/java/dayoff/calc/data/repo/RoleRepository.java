package dayoff.calc.data.repo;

import dayoff.calc.data.SessionExecutor;
import dayoff.calc.model.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mac on 04.08.17.
 */
@Repository
public class RoleRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public List<Role> getRolesByUserId(long userId) {
        return sessionExecutor.readSession((s) ->
                s.createCriteria(Role.class).add(Restrictions.eq("user.id", userId)).list());
    }


    public void save(Role role) {
        sessionExecutor.updateSession((s) -> {
            s.persist(role);
            return null;
        });
    }

}
