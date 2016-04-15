package example.framework.layer.protocol.response;

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
    Set<Integer> codes=new LinkedHashSet<>();

    int getCode();

    String getMessage();

    public String toString();

    public String toString(String remark);
}
