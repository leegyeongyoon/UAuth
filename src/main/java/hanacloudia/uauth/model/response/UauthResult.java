package hanacloudia.uauth.model.response;

import hanacloudia.uauth.entity.UserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UauthResult {
    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 : >= 0 정상 , < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지 ")
    private String message;

    @ApiModelProperty(value = "Data ")
    private UserEntity data;

    @ApiModelProperty(value = "token ")
    private String token;
}