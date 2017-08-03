package dayoff.calc.security;

import dayoff.calc.data.UserRepository;
import dayoff.calc.model.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 07.07.17.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userRepository.getByName(username);
        user.setAuthorities(userRepository.getRolesByUserid(user.getId()));

        System.out.println(user.toString());

        return new UserPrincipal(user);
    }
}
