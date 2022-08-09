package hanacloudia.uauth.service;


import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UAuthRequestParam;

public interface UAuthService {
    UserEntity signin(UAuthRequestParam userRequestParam);
    UserEntity signCheckSample(UAuthRequestParam userRequestParam);
    UserEntity userInfo(UAuthRequestParam userRequestParam);

}
