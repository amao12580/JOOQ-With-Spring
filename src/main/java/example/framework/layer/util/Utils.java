package example.framework.layer.util;

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

    //对日期时间的操作    结束



    //对JSON的操作    开始

    public static String toJsonString(Object obj){
        return jsonUtil.toJsonString(obj);
    }

    public static String toJsonString(Map<String,Object> map){
        return jsonUtil.toJsonString(map);
    }

    //对JSON的操作    结束
}
