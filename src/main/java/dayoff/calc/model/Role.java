package dayoff.calc.model;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mac on 07.07.17.
 */
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class Role implements GrantedAuthority, Serializable {
    public final static String USER = "ROLE_USER";
    public final static String ADMIN = "ROLE_ADMIN";

    @ManyToOne
    User user;

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}