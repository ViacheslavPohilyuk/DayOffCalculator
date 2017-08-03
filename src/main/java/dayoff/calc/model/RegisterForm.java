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
@ToString
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

    public RegisterForm() {
    }

    public RegisterForm(String username, String password, String second_password) {
        this.username = username;
        this.password = password;
        this.second_password = second_password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecond_password() {
        return second_password;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "username", "password", "second_password");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "username", "password", "second_password");
    }
}
