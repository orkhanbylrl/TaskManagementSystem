package App.controller;

import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import App.model.dto.UserRq;
import App.service.AuthService;
import App.service.JwtService;
import App.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResp> login(@RequestBody UserRq rq) {
        String token = "";
        UserResp user = null;
        Authentication login = authService.login(rq);
        if(login.isAuthenticated()) {
            token = jwtService.generateToken(userService.loadUserByUsername(rq.getEmail()));
            user = userService.getUser(rq.getEmail());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return ResponseEntity.ok().headers(headers).body(user);
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResp register(@RequestBody UserRegDTO userRegDTO) {
        return authService.register(userRegDTO);
    }
}
