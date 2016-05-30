package example.framework.layer.constant;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:17:27
 */
public class ErrorConstant {
    private static Set<Integer> codes = new LinkedHashSet<>();

    public static boolean set(Integer code) {
        return codes.add(code);
    }

    public static boolean isEmpty() {
        return codes.isEmpty();
    }
}
