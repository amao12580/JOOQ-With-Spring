package example.framework.layer.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogHelper {

    private static String getStackTraceInfo(StackTraceElement[] stack) {
        StackTraceElement stackTraceElement = stack[1];
        return "[" + stackTraceElement.getClassName() + "] [" + stackTraceElement.getMethodName() + "] [" + stackTraceElement.getLineNumber() + "]";
    }

    public static void info(String format, Object... arguments) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        if (logger.isInfoEnabled()) {
            logger.info(format, arguments);
        }
    }

    public static void error(String format, Object... arguments) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        if (logger.isErrorEnabled()) {
            logger.error(format, arguments);
        }
    }

    public static void debug(String format, Object... arguments) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        if (logger.isDebugEnabled()) {
            logger.debug(format, arguments);
        }
    }

    public static void warn(String format, Object... arguments) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        logger.warn(format, arguments);
    }

    public static void exception(Exception e) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        if (logger.isErrorEnabled()) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void exception(String msg, Throwable e) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = LoggerFactory.getLogger(getStackTraceInfo(stack));
        if (logger.isErrorEnabled()) {
            logger.error(msg, e);
        }
    }
}
