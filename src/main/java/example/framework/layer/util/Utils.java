package example.framework.layer.util;

import com.alibaba.fastjson.JSON;
import example.framework.layer.exception.CheckException;
import example.framework.layer.protocol.response.Error;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Utils{
    private static DatetimeUtil datetimeUtil;
    private static JsonUtil jsonUtil;


    //对日期时间的操作    开始

    public static long now(){
        return datetimeUtil.now();
    }

    public static Timestamp nowTime(){
        return new Timestamp(now());
    }

    //对日期时间的操作    结束



    //对JSON的操作    开始

    public static String toString(Object obj){
        return jsonUtil.toJsonString(obj);
    }

    public static String toString(Map<String, Object> map){
        return jsonUtil.toJsonString(map);
    }

    public static <T> T parseObject(String text, Class<T> clazz){
        return jsonUtil.parseObject(text, clazz);
    }

    //对JSON的操作    结束


    //对数据检查的操作    开始
    /**
     * 如果actual与expect不相等(euqals)时，抛出异常
     * @param actual  实际值
     * @param expect 期望值
     * @param error 异常
     */
    public static void throwIfNotEquals(Object actual,Object expect, Error error) {
        throwIfNull(actual,error);
        throwIfNull(expect,error);
        if (actual.equals(expect)) {
            throw new CheckException(error);
        }
    }

    public static void throwIfNotEquals(Object actual,Object expect, Error error,String remark) {
        throwIfNull(actual,error,remark);
        throwIfNull(expect,error,remark);
        if (actual.equals(expect)) {
            throw new CheckException(error,remark);
        }
    }

    public static void throwIfNull(Object actual, Error error) {
        if (null==actual) {
            throw new CheckException(error);
        }
    }

    public static void throwIfNull(Object actual, Error error,String remark) {
        if (null==actual) {
            throw new CheckException(error,remark);
        }
    }

    //对数据检查的操作    结束
}
