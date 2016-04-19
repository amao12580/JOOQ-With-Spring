package example.framework.layer.security;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:15:24
 */
public interface SercurityGuard {
    Set<SercurityGuard> guards=new HashSet<>();
    /**.
     * 检查参数中是否包含有风险的参数
     * @param args 待检查参数
     * @return 结果  true=可以通过；false=不允许执行
     */
    boolean checkRisk(Object ...args);
}
