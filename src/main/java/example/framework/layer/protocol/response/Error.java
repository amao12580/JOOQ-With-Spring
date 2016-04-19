package example.framework.layer.protocol.response;

import example.framework.layer.constant.ErrorConstant;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/15
 * Time:14:27
 */
public interface Error {
    int defaultCode=0;
    String defaultMessage="ok.";

    static boolean set(Integer code){
        return ErrorConstant.set(code);
    }

    static boolean isEmpty(){
        return ErrorConstant.isEmpty();
    }

    int getCode();

    String getMessage();

    public String toString();

    public String toString(String remark);
}
