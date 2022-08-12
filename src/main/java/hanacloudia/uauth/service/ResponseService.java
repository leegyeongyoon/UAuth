package hanacloudia.uauth.service;

import hanacloudia.uauth.entity.HanaUserEntity;
import hanacloudia.uauth.entity.UserEntity;
import hanacloudia.uauth.model.response.HanaApiResult;
import hanacloudia.uauth.model.response.UauthResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    public enum Response {

        SUCCESS(200, "성공하였습니다."),
        FAIL(1000, "실패하였습니다.");

        int code;
        String msg;

        Response(int code, String msg) {
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
        setSuccessResult(result, data);
        return result;
    }

    public UauthResult getFailResult(int code, String msg) {
        UauthResult result = new UauthResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    private void setSuccessResult(UauthResult result, UserEntity data) {
        result.setSuccess(true);
        result.setCode(Response.SUCCESS.getCode());
        result.setMessage(Response.SUCCESS.getMsg());
        result.setData(data);
    }

    public HanaApiResult defaultResult(List<HanaUserEntity> list){
        HanaApiResult result = new HanaApiResult();
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage("성공하였습니다");
        result.setList(list);
        return result;
    }
}
