package dayoff.calc.model.form;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
/*------------------------------------------------------------*/
public class RegisterForm {

    @NotNull
    @Size(min = 2, max = 35, message = "{register.username.size}")
    private String username;

    @NotNull
    @Size(min = 5, max = 25, message = "{register.password.size}")
    private String password;

    @NotNull
    @Size(min = 5, max = 25, message = "{register.confirm_password.size}")
    private String confirmPassword;
}
