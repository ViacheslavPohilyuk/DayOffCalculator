package dayoff.calc.model;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mac on 03.08.17.
 */
/* Lombok annotations
 * for generating getters, setters, toString and constructors */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
/*------------------------------------------------------------*/
public class RegisterForm {

    @NotNull
    @Size(min = 2, max = 35, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;

    @NotNull
    @Size(min = 5, max = 25, message = "{second_password.size}")
    private String second_password;
}
