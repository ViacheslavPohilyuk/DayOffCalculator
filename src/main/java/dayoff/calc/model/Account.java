package dayoff.calc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 11.04.17.
 */
/* Lombok annotations
 * for generating getters, setters, toString and constructors */
@Getter
@Setter
@ToString()
@NoArgsConstructor
@AllArgsConstructor
/*------------------------------------------------------------*/
@Entity
@Table(name = "users")
public class Account implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    @JsonIgnore
    private List<Role> authorities = new ArrayList<>();

    public Account(String username, String password, List<Role> authorities) {
        this(null, username, password, authorities);
    }
}
