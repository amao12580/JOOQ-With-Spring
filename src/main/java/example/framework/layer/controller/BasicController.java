package example.framework.layer.controller;

import example.framework.layer.log.LogHelper;
import example.framework.layer.protocol.response.BasicError;
import example.framework.layer.protocol.response.Result;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/15
 * Time:16:07
 */
public abstract class BasicController {
    private static final Result error=new Result(BasicError.SYSTEM_INNER_ERROR);

    public Result safetyExcute(Object ... objects) {
        Result result = null;
        try {
            result=this.excute(objects);
        } catch (Exception e) {
            LogHelper.error("The server appeared abnormal.", e);
            result = error;
        } finally {
            if (result == null) {
                LogHelper.error("Unpredictable problem happened.");
                result = error;
            }
        }
        return result;
    }
    public abstract Result excute(Object ... objects);
}
