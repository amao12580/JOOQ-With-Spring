package example.base.layer.protocol.response;


import example.framework.layer.protocol.response.BasicError;
import example.framework.layer.protocol.response.Error;
import example.framework.layer.util.Utils;

public enum APIError implements Error {
    DEFAULT,
    ORDER_NOT_EXISTS(1000,"订单不存在"),
    ;

    private int code= BasicError.DEFAULT.getCode();

    private String message= BasicError.DEFAULT.getMessage();

    APIError(){
    }


    @Override
    public final int getCode() {
        return code;
    }

    @Override
    public final String getMessage() {
        return message;
    }

    @Override
    public final String toString() {
        return Utils.toString(this);
    }

    @Override
    public String toString(String remark) {
        return BasicError.DEFAULT.toString(this,remark);
    }

    APIError(int code, String message) {
        BasicError.DEFAULT.checkRepeatDefined(code);
        this.code = code;
        this.message = message;
    }
}
