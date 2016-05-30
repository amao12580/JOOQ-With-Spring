package example.framework.layer.plugin;

import example.framework.layer.security.SercurityGuard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:16:30
 */
public interface BasicPlugins {
    Set<SercurityGuard> sercurityGuards = new HashSet<>();
}
