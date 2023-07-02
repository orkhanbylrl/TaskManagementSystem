package App.service;

import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import App.model.dto.UserRq;
import org.springframework.security.core.Authentication;

public interface AuthService {
    UserResp register(UserRegDTO regDTO);
    Authentication login(UserRq rq);
}
