package example.framework.layer.protocol.response;

import example.base.layer.protocol.response.APIError;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/15
 * Time:15:39
 */

public class Result {
    @Getter
    @Setter
    private int code= APIError.DEFAULT.getCode();

    @Getter
    @Setter
    private String message= APIError.DEFAULT.getMessage();

    private Object data;

    public Result(){
    }

    public Result(Error error){
        this.code=error.getCode();
        this.message=error.getMessage();
    }

    public Result(Error error,String message){
        this.code=error.getCode();
        this.message=message;
    }

    public Result(int code,String message){
        this.code=code;
        this.message=message;
    }

    public Result(Object data){
        this.data=data;
    }

    public Object getData() {
        return data;
    }
}
