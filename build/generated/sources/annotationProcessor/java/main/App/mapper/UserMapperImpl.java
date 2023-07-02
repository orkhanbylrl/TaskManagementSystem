package App.mapper;

import App.dao.entity.User;
import App.model.dto.UserRegDTO;
import App.model.dto.UserResp;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-03T02:03:54+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserRegDTO userRegDTO) {
        if ( userRegDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.fullName( userRegDTO.getFullName() );
        user.email( userRegDTO.getEmail() );
        user.password( userRegDTO.getPassword() );

        return user.build();
    }

    @Override
    public UserResp mapToUserResp(User user) {
        if ( user == null ) {
            return null;
        }

        UserResp.UserRespBuilder userResp = UserResp.builder();

        userResp.id( user.getId() );
        userResp.fullName( user.getFullName() );
        userResp.email( user.getEmail() );

        return userResp.build();
    }
}
