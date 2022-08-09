package hanacloudia.uauth.service.impl;

import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UAuthRequestParam;
import hanacloudia.uauth.repository.UAuthRepository;
import hanacloudia.uauth.service.UAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UAuthServiceImpl implements UAuthService, UserDetailsService {
    private final UAuthRepository UAuthRepository;

    @Override
    public UserEntity signin(UAuthRequestParam userRequestParam) {
            return UAuthRepository.findByHanaPrtlEmpNoAndPassword(userRequestParam.getUid(), userRequestParam.getPassword());
    }

    @Override
    public UserEntity signCheckSample(UAuthRequestParam userRequestParam) {
        return UAuthRepository.findByHanaPrtlEmpNo(userRequestParam.getUid());
    }

    @Override
    public UserEntity userInfo(UAuthRequestParam userRequestParam) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(userRequestParam.getUid() != authentication.getName()){
            return null;
        }
        else {
            return UAuthRepository.findByHanaPrtlEmpNoAndPassword(authentication.getName(), userRequestParam.getPassword());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = UAuthRepository.findByHanaPrtlEmpNo(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(userEntity.getHanaPrtlEmpNo(),userEntity.getPassword(),authorities);
    }
}
