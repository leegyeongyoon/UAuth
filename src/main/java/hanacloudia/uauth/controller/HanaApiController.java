package hanacloudia.uauth.controller;

import hanacloudia.uauth.entity.HanaUserEntity;
import hanacloudia.uauth.model.response.HanaApiResult;
import hanacloudia.uauth.service.HanaApiService;
import hanacloudia.uauth.service.ResponseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@ApiResponses({
        @ApiResponse(code = 1000, message = "This member not exist"),
        @ApiResponse(code = 1001, message = "Your account does not exist or your email"),
        @ApiResponse(code = 1002, message = "You do not have permission to access this resource"),
        @ApiResponse(code = 1003, message = "A Resource that can not be access with the privileges it has"),
        @ApiResponse(code = 1004, message = "An error occurred during communication"),
        @ApiResponse(code = 1005, message = "you are an existing member"),
        @ApiResponse(code = 9999, message = "An unknown error has occurred"),
})
public class HanaApiController {

    private final HanaApiService hanaApiService;
    private final ResponseService responseService;
    @Value(value = "${auth.token}")
    private String authToken;

    @GetMapping("/signin")
    private HanaApiResult signin(@RequestParam("uid") String uid,
                                 @RequestParam("password") String password) {
        List<HanaUserEntity> user = hanaApiService.signin(uid, password);
        return responseService.defaultResult(user);
    }

    @GetMapping("/getempl")
    private HanaApiResult getEmpl(@RequestParam("X-AUTH_TOKEN") String token,
                                  @RequestParam("name") String name) {
        List<HanaUserEntity> user = hanaApiService.getEmpl(name);
        if (authToken.equals(token)) {
            return responseService.defaultResult(user);
        } else {
            return responseService.falseResult();
        }

    }

    @GetMapping("/getemplbyempno")
    private HanaApiResult getemplbyempno(@RequestParam("X-AUTH_TOKEN") String token,
                                         @RequestParam("empno") String empno) {
        List<HanaUserEntity> user = hanaApiService.getEmplbyEmpno(empno);
        if (authToken.equals(token)) {
            return responseService.defaultResult(user);
        } else {
            return responseService.falseResult();
        }

    }

    @GetMapping("/getemplbyid")
    private HanaApiResult getEmplById(@RequestParam("X-AUTH_TOKEN") String token,
                                      @RequestParam("emalAdr") String email) {
        List<HanaUserEntity> user = hanaApiService.getEmplById(email);
        if (authToken.equals(token)) {
            return responseService.defaultResult(user);
        } else {
            return responseService.falseResult();
        }
    }
}
