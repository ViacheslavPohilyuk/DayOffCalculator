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
        List<Role> roles = sessionExecutor.readSession((s) ->
                s.createCriteria(Role.class).add(Restrictions.eq("user.id", userId)).list());

        System.out.println("Roles: ");
        for (Role role : roles)
            System.out.println(role.toString());
        return roles;
    }


    public void save(Role role) {
        sessionExecutor.updateSession((s) -> {
            System.out.println(role.toString());
            s.persist(role);
            return null;
        });
    }

}
