package App.service;

import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {
    UserResp save(UserRegDTO userRegDTO);
    UserResp getUser(String email);
    UserDetails loadUserByUsername(String email);
}
