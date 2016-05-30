package example.framework.layer.security.plugins;

import example.framework.layer.log.LogHelper;
import example.framework.layer.plugin.BasicPlugins;
import example.framework.layer.security.SercurityGuard;
import example.framework.layer.security.plugins.impl.XSS.XSSSercurityHandler;

/**
 * 管理所有安全问题插件
 * <p>
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:15:35
 */
public enum SercurityPlugins implements BasicPlugins {
    XSS(new XSSSercurityHandler()) {
        @Override
        boolean check(Object... args) {
            boolean ret = SercurityPlugins.XSS.getGuard().checkRisk(args);
            LogHelper.info("XSS模块检查结果是:{}", ret);
            return ret;
        }
    };

    SercurityPlugins(SercurityGuard guard) {
        sercurityGuards.add(guard);
        this.guard = guard;
    }

    private SercurityGuard guard;

    private SercurityGuard getGuard() {
        return this.guard;
    }

    abstract boolean check(Object... args);

    /**
     * 安全检查
     *
     * @param args 请求的参数
     * @return 检查结果，true=可以通过；false=不允许执行
     */
    public static boolean checkAll(Object... args) {
        boolean result = false;
        for (SercurityPlugins arr : SercurityPlugins.values()) {
            if (arr.check(args)) {//存在风险
                return false;
            } else {
                result = true;
            }
        }
        return result;
    }
}
