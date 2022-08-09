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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@RequestMapping("/api")
@ApiResponses({
        @ApiResponse(code = 1000, message = "This member not exist"),
        @ApiResponse(code = 1001, message = "Your account does not exist or your email"),
        @ApiResponse(code = 1002, message = "You do not have permission to access this resource"),
        @ApiResponse(code = 1003, message = "A Resource that can not be access with the privileges it has"),
        @ApiResponse(code = 1004, message = "An error occurred during communication"),
        @ApiResponse(code = 1005, message = "you are an existing member"),
        @ApiResponse(code = 9999, message = "An unkhown error has occurred"),
        })
public class HanaApiController {
}
