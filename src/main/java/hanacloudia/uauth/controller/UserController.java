package hanacloudia.uauth.controller;

import hanacloudia.uauth.config.jwt.JwtTokenProvider;
import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UserRequestParam;
import hanacloudia.uauth.model.response.UauthResult;
import hanacloudia.uauth.service.ResponseService;
import hanacloudia.uauth.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    private final ResponseService responseService;


//    @PostMapping("/signin")
//    private String signin(@RequestBody UserRequestParam reqParams, HttpServletRequest request) {
//        UserEntity user = userService.signin(reqParams);
//        ArrayList<String> roles = new ArrayList<>();
//        roles.add("USER");
//        System.out.println("test");
//        if (user != null) {
//            String token = jwtTokenProvider.createToken(user.getHanaPrtlEmpNo(), roles);
//            System.out.println(token);
//            System.out.println("HttpStatus.values()"+HttpStatus.values());
//            return token;
//        } else {
//
//            return "false";
//        }
//
//    }

    @PostMapping("/signin") // Uauth 멤버 로그인
    private UauthResult signin(@RequestBody UserRequestParam reqParams, HttpServletRequest request) {
        UserEntity user = userService.signin(reqParams);
        ArrayList<String> roles = new ArrayList<>(); //안봐도 된다
        roles.add("USER");//안봐도 된다
        if (user != null) {
            String token = jwtTokenProvider.createToken(user.getHanaPrtlEmpNo(), roles);//안봐도 된다
            user.setToken(token);//안봐도 된다
            return responseService.getSuccessResult(user,token);
        } else {
            return responseService.getFailResult(1001,"Your account does not exist or your email.");
        }

    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", defaultValue = "None", required = true, dataType = "String", paramType = "header")
    @PostMapping("/memberList")
    private UserEntity memberList(@RequestBody UserRequestParam reqParams, HttpServletRequest request) {
        return userService.userInfo(reqParams);
    }
}
