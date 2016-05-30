package example.framework.layer.util;

import org.joda.time.DateTime;

/**
 * Created by Administrator on 2016/4/13.
 */
public class DatetimeUtil {
    protected static long now() {
        return DateTime.now().getMillis();
    }
}
