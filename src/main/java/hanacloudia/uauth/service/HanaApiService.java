package hanacloudia.uauth.service;

import hanacloudia.uauth.entity.HanaUserEntity;
import hanacloudia.uauth.model.HanaApiRequestParam;

import java.util.List;

public interface HanaApiService {
    List<HanaUserEntity> signin(String uid, String password);
    List<HanaUserEntity> getEmpl(String name);
    List<HanaUserEntity> getEmplbyEmpno(String empno); //사번
    List<HanaUserEntity> getEmplById(String email); //아이디(이메일)
}
