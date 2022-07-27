package hanacloudia.uauth.service;


import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UserRequestParam;

import java.util.Map;

public interface UserService {
    UserEntity signin(UserRequestParam userRequestParam);
    UserEntity userInfo(UserRequestParam userRequestParam);

}
