package App.service.impl;

import App.dao.entity.User;
import App.dao.repository.UserRepository;
import App.model.exception.UserNotFoundException;
import App.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = repo.findUsersByEmail(email);
        return user.map(UserDetailsImpl::new).orElseThrow(() -> new UserNotFoundException("User is not exist!"));
    }
}
