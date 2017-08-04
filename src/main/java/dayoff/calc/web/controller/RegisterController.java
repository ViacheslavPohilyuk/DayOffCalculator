package dayoff.calc.web.controller;

import dayoff.calc.data.repo.RoleRepository;
import dayoff.calc.data.repo.UserRepository;
import dayoff.calc.model.RegisterForm;
import dayoff.calc.model.User;
import dayoff.calc.web.exception.DuplicateUsernameException;
import dayoff.calc.web.exception.PasswordsNotEqualException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 04.08.17.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = GET)
    public String registerForm(Model model) {
        model.addAttribute(new RegisterForm());
        return "registerForm";
    }

    @RequestMapping(method = POST)
    public String register(@ModelAttribute("registerForm") @Valid RegisterForm form, BindingResult bindingResult) {
        System.out.println(form.toString());

        /* Check validation of the registration form */
        if (bindingResult.hasErrors())
            return "registerForm";

        /* Check if username from the registration form exists in the db */
        String formUsername = form.getUsername();
        List<String> usernames = userRepository.getUsernames();
        for (String u : usernames)
            if (u.equals(formUsername)) {
                System.out.println("duplicate");
                throw new DuplicateUsernameException();
            }

        if (!form.getPassword().equals(form.getSecond_password())) {
            System.out.println("pass");
            throw new PasswordsNotEqualException();
        }

        /* Encode password */
        String encodedPassword = passwordEncoder.encode(form.getPassword());

        /* Save new user */
        User user = new User(form.getUsername(), encodedPassword, null);
        userRepository.save(user);

        /* Save new role and bind to a new user */
        // long userId = userRepository.getByName(user.getUsername()).getId();
        // Role role = new Role(Role.USER);
        // role.getUser().setId(userId);
        // roleRepository.save(role);

        System.out.println(user.toString());
        return "login";
    }
}
