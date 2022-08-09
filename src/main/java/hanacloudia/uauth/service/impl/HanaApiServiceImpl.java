package hanacloudia.uauth.service.impl;

import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UAuthRequestParam;
import hanacloudia.uauth.repository.UAuthRepository;
import hanacloudia.uauth.service.HanaApiService;
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

public class HanaApiServiceImpl implements HanaApiService {

}
