package dayoff.calc.security;

import dayoff.calc.data.repo.RoleRepository;
import dayoff.calc.data.repo.UserRepository;
import dayoff.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/calc")
                    .failureUrl("/login?error")
                    .permitAll()
                    .loginProcessingUrl("/auth/login_check")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/").logoutUrl("/logout")
                .and()
                    .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService((username) -> {
            User user = userRepository.getByName(username);

            user.setAuthorities(roleRepository.getRolesByUserId(user.getId()));

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
        });

        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}
