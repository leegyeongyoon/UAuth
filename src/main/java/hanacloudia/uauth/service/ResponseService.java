package hanacloudia.uauth.service;

import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.response.UauthResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public enum UauthResponse {
        SUCCESS(200, "성공하였습니다."),
        FAIL(1000, "실패하였습니다.");

        int code;
        String msg;

        UauthResponse(int code, String msg) {
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

    public UauthResult getSuccessResult(UserEntity data, String token) {
        UauthResult result = new UauthResult();
        setSuccessResult(result, data, token);
        return result;
    }

    public UauthResult getFailResult(int code, String msg) {
        UauthResult result = new UauthResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    private void setSuccessResult(UauthResult result, UserEntity data, String token) {
        result.setSuccess(true);
        result.setCode(UauthResponse.SUCCESS.getCode());
        result.setMessage(UauthResponse.SUCCESS.getMsg());
        result.setData(data);
        result.setToken(token);
    }
}
