package hanacloudia.uauth.service.impl;

import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UserRequestParam;
import hanacloudia.uauth.repository.UserRepository;
import hanacloudia.uauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserEntity signin(UserRequestParam userRequestParam) {
            return userRepository.findByHanaPrtlEmpNoAndPassword(userRequestParam.getUid(), userRequestParam.getPassword());
    }

    @Override
    public UserEntity userInfo(UserRequestParam userRequestParam) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(userRequestParam.getUid() != authentication.getName()){
            return null;
        }
        else {
            return userRepository.findByHanaPrtlEmpNoAndPassword(authentication.getName(), userRequestParam.getPassword());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByHanaPrtlEmpNo(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(userEntity.getHanaPrtlEmpNo(),userEntity.getPassword(),authorities);
    }
}
