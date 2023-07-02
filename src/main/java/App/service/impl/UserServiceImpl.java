package App.service.impl;

import App.dao.entity.User;
import App.dao.repository.UserRepository;
import App.mapper.UserMapper;
import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import App.model.dto.UserRq;
import App.model.exception.UserNotFoundException;
import App.service.JwtService;
import App.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repo;

    @Override
    public UserResp save(User user) {
        return UserMapper.MAPPER.mapToUserResp(repo.save(user));
    }

    @Override
    public UserResp getUser(String email) {
        User user = repo.findUsersByEmail(email).orElseThrow(() -> new UserNotFoundException("User is not found!"));
        return UserMapper.MAPPER.mapToUserResp(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = repo.findUsersByEmail(email);
        return user.map(UserDetailsImpl::new).orElseThrow(() -> new UserNotFoundException("User is not exist!"));
    }

}
