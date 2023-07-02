package App.service;

import App.dao.entity.User;
import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import App.model.dto.UserRq;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {
    UserResp save(User user);
    UserResp getUser(String email);
    UserDetails loadUserByUsername(String email);

}
