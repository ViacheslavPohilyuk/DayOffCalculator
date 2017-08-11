package dayoff.calc.web.controller;

import dayoff.calc.data.repo.UserRepository;
import dayoff.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 13.05.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = GET)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody Collection<User> users() {
        return userRepository.getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    //@PreAuthorize("hasRole('ROLE_USER')")
    public User user(@PathVariable long id) {
        return userRepository.get(id);
    }

    @RequestMapping(value = "/name/{username}", method = GET)
    //@PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody User user(@PathVariable String username) {
        return userRepository.getByName(username);
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
