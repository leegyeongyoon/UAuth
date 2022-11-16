package hanacloudia.uauth.service.impl;

import hanacloudia.uauth.entity.HanaUserEntity;
import hanacloudia.uauth.repository.HanaApiRepository;
import hanacloudia.uauth.service.HanaApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HanaApiServiceImpl implements HanaApiService {
    private final HanaApiRepository HanaApiRepository;

    @Override
    public List<HanaUserEntity> signin(String uid, String password){
        return HanaApiRepository.findByHanaPrtlEmpNoAndPassword(uid, password);
    }

    @Override
    public List<HanaUserEntity> getEmpl(String name){
        return HanaApiRepository.findByHanaprtlEmpNm(name);
    }

    @Override
    public List<HanaUserEntity> getEmplbyEmpno(String empno){
        return HanaApiRepository.findByHanaPrtlEmpNo(empno);
    }

    @Override
    public  List<HanaUserEntity> getEmplById(String email){
        return HanaApiRepository.findByHanaPrtlEmpNo(email);
    }

}
