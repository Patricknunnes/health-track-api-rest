package br.com.fiap.healthtrack.config.security;

import br.com.fiap.healthtrack.model.User;
import br.com.fiap.healthtrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            return user.get();
        } else {
            throw new UsernameNotFoundException("Invalid User!");
        }
    }
}
