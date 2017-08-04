package dayoff.calc.web.controller;

import dayoff.calc.data.UserRepository;
import dayoff.calc.model.RegisterForm;
import dayoff.calc.model.Role;
import dayoff.calc.model.User;
import dayoff.calc.web.exception.DuplicateUsernameException;
import dayoff.calc.web.exception.PasswordsNotEqualException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 13.05.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = GET)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<User> users() {
        return userRepository.getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    //@PreAuthorize("hasRole('ROLE_USER')")
    public User user(@PathVariable long id) {
        return userRepository.get(id);
    }

    /* @ModelAttribute("registerForm")
    public RegisterForm getRegisterForm() {
        return new RegisterForm();
    } */

    @RequestMapping(value = "/register", method = GET)
    public String registerForm(Model model) {
        model.addAttribute(new RegisterForm());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(@ModelAttribute("registerForm") @Valid RegisterForm form, BindingResult bindingResult) {
        System.out.println(form.toString());

        if (bindingResult.hasErrors())
            return "registerForm";

        String username = form.getUsername();
        if (username != null) {
            System.out.println("duplicate");
            throw new DuplicateUsernameException();
        }

        if (!form.getPassword().equals(form.getSecond_password())) {
            System.out.println("pass");
            throw new PasswordsNotEqualException();
        }

        /* Encode password */
        String encodedPassword = passwordEncoder.encode(form.getPassword());

        /* Set list of roles for a user */
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(new Role(Role.USER));

        User user = new User(form.getUsername(), encodedPassword, userRoles);

        System.out.println(user.toString());

        userRepository.save(user);

        return "login";
    }

    @RequestMapping(method = PUT)
    //@PreAuthorize("#user.id == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateId(User user) {
        userRepository.update(user);
        return new ResponseEntity<>("User have been successfully changed", HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = DELETE)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteId(@PathVariable long id) {
        userRepository.delete(id);
        return new ResponseEntity<>("User have been successfully deleted", HttpStatus.OK);
    }
}
