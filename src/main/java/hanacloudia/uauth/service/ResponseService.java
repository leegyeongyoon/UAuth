package hanacloudia.uauth.service;

import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.response.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public enum CommonResponse {
        SUCCESS(200, "성공하였습니다."),
        FAIL(-1, "실패하였습니다.");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;

        }
    }

    public CommonResult getSuccessResult(UserEntity data, String token) {
        CommonResult result = new CommonResult();
        setSuccessResult(result, data, token);
        return result;
    }

    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    private void setSuccessResult(CommonResult result, UserEntity data, String token) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMsg());
        result.setData(data);
        result.setToken(token);
    }
}
