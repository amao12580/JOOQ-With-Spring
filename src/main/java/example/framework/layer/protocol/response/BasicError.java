package example.framework.layer.protocol.response;


import example.framework.layer.exception.CheckException;
import example.framework.layer.util.Utils;

import java.util.HashMap;
import java.util.Map;

public enum BasicError implements Error {
    DEFAULT(defaultCode,defaultMessage),
    SYSTEM_INNER_ERROR(1,"系统内部错误."),

    ;

    private int code=defaultCode;
    private String message=defaultMessage;

    static {
        init();
    }

    private static void init() {
        if(Error.isEmpty()){
            for (BasicError type : BasicError.values()) {
                checkRepeatDefined(type.getCode());
            }
        }
    }

    BasicError(int code, String message){
        checkRepeatDefined(code);
        this.code=code;
        this.message=message;
    }

    public final static void checkRepeatDefined(int code) {
        if(!Error.set(code)){
            throw new CheckException(SYSTEM_INNER_ERROR,"检查到重复的错误码定义："+code);
        }
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
        return toString(this,remark);
    }

    public String toString(Error result,String remark) {
        Map<String,Object> map=new HashMap<>(2);
        map.put("code",result.getCode());
        map.put("message", remark);
        return Utils.toString(map);
    }
}
