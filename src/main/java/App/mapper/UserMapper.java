package App.mapper;

import App.dao.entity.User;
import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    User mapToUser(UserRegDTO userRegDTO);
    UserResp mapToUserResp(User user);
}
