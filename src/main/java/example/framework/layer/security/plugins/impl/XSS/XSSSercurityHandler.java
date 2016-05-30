package example.framework.layer.security.plugins.impl.XSS;

import example.framework.layer.log.LogHelper;
import example.framework.layer.security.SercurityGuard;
import example.framework.layer.util.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 解决SQL注入或脚本注入的安全问题
 * <p>
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:15:27
 */
public class XSSSercurityHandler implements SercurityGuard {
    /**
     * 风险值与覆盖值的键值对
     */
    private static Map<String, String> riskTags = new HashMap<>();

    static {
        riskTags.put("<", "& lt;");
        riskTags.put(">", "& gt;");
        riskTags.put("\\(", "& #40;");
        riskTags.put("\\)", "& #41;");
        riskTags.put("'", "& #39;");
        riskTags.put("eval\\((.*)\\)", "");
        riskTags.put("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        riskTags.put("script", "");
    }

    /**
     * .
     * 检查参数中是否包含有风险的参数
     *
     * @param args 待检查参数
     * @return 结果 true=可以通过；false=不允许执行
     */
    @Override
    public boolean checkRisk(Object... args) {
        LogHelper.info("XSS模块开始检查，args:{}", Utils.toString(args));
        for (Object obj : args) {
            if (obj != null) {
                String str = obj.toString();
                Set<String> riskKeys = riskTags.keySet();
                Iterator<String> iterator = riskKeys.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (str.contains(key)) {
                        LogHelper.error("参数值:{},存在不合法标记:{}", str, key);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
