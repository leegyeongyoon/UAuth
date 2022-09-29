package hanacloudia.uauth.controller;

import hanacloudia.uauth.config.jwt.JwtTokenProvider;
import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.UAuthRequestParam;
import hanacloudia.uauth.model.response.UauthResult;
import hanacloudia.uauth.service.ResponseService;
import hanacloudia.uauth.service.UAuthService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@ApiResponses({
        @ApiResponse(code = 1000, message = "This member not exist"),
        @ApiResponse(code = 1001, message = "Your account does not exist or your email"),
        @ApiResponse(code = 1002, message = "You do not have permission to access this resource"),
        @ApiResponse(code = 1003, message = "A Resource that can not be access with the privileges it has"),
        @ApiResponse(code = 1004, message = "An error occurred during communication"),
        @ApiResponse(code = 1005, message = "you are an existing member"),
        @ApiResponse(code = 9999, message = "An unkhown error has occurred"),
        })
public class UAuthController {
    private final UAuthService uAuthService;
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
    private UauthResult signin(@RequestBody UAuthRequestParam reqParams, HttpServletRequest request) {
        UserEntity user = uAuthService.signin(reqParams);
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
    private UserEntity memberList(@RequestBody UAuthRequestParam reqParams, HttpServletRequest request) {
        return uAuthService.userInfo(reqParams);
    }

    @PostMapping("/signcheckSample")
    private UserEntity signCheckSample(@RequestBody UAuthRequestParam reqParams, HttpServletRequest request) {
        return uAuthService.signCheckSample(reqParams);
    }
}
