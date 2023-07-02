package App.service.impl;

import App.dao.entity.User;
import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import App.model.dto.UserRq;
import App.service.AuthService;
import App.service.JwtService;
import App.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;


    @Override
    public UserResp register(UserRegDTO regDTO) {
        User user = User.builder()
                .fullName(regDTO.getFullName())
                .email(regDTO.getEmail())
                .password(encoder.encode(regDTO.getPassword()))
                .build();

        return userService.save(user);
    }

    @Override
    public Authentication login(UserRq rq) {
        log.info("authentication started");
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                rq.getEmail(),
                rq.getPassword()
        );
        log.info("authentication ended");
        return authManager.authenticate(authToken);
    }
}
