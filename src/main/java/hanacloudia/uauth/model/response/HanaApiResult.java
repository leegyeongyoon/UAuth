package hanacloudia.uauth.model.response;


import hanacloudia.uauth.entity.HanaUserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HanaApiResult {
    @ApiModelProperty(value=" 응답 성공여부 : true/false ")
    private boolean success;

    @ApiModelProperty(value=" 응답 코드 ")
    private int code;

    @ApiModelProperty(value=" 응답 메시지 ")
    private String msg;

    @ApiModelProperty(value=" List ")
    private List<HanaUserEntity> list;
}
