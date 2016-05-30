package example.framework.layer.controller.interceptor;

import example.framework.layer.exception.BaseException;
import example.framework.layer.log.LogHelper;
import example.framework.layer.protocol.response.BasicError;
import example.framework.layer.protocol.response.Result;
import example.framework.layer.security.plugins.SercurityPlugins;
import example.framework.layer.util.Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:12:37
 * <p>
 * REF:http://www.cnblogs.com/shunyang/p/3300179.html
 */
//声明该类为一个切面
@Aspect
@EnableAspectJAutoProxy
@Component
public class SafetyResponseInterceptor {
    private static final Result error = new Result(BasicError.SYSTEM_INNER_ERROR);

    // excute() 声明一个切入点,用一个方法表示

    // 拦截example.controller.layer下返回值为任意类型的所有方法,参数可有可无,个数不限定
    //@Pointcut("execution (* example.controller.layer..*.*(..))")

    // 拦截所有拥有@ResponseBody注解的方法执行
    @Pointcut("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    private void excute() {
    }

    @Before("excute()&&args(params)")//获取参数名称为params的参数值
    public void doAccessCheck(Object... params) {
        LogHelper.info("前置通知，params字段的值是:{}", Utils.toString(params));
    }

    @Before("excute()")
    public void doAccessCheck(JoinPoint point) {//获取所有的参数，可以做SQL注入等多个安全检查
        LogHelper.info("前置通知，输入参数为:{}", Utils.toString(point.getArgs()));
        Utils.throwIfNotEquals(SercurityPlugins.checkAll(point.getArgs()), true, BasicError.SYSTEM_INNER_ERROR, "检查到非法参数，拒绝执行.");
    }

    // 返回值类型为字符串
    @AfterReturning(pointcut = "excute()", returning = "result")
    public void doAfterReturning(Result result) {
        LogHelper.info("后置通知:{}", Utils.toString(result));
    }

    @After("excute()")
    public void doAfter() {
        LogHelper.info("最终通知");
    }

    @AfterThrowing(pointcut = "excute()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        LogHelper.exception("例外通知.", e);
    }

    // 环绕通知
    @Around("excute()")
    public Result safetyExcute(ProceedingJoinPoint pjp) throws Throwable {
        // if(){//判断用户是否在权限
        LogHelper.info("进入方法");
        Result result = null;
        try {
            result = (Result) pjp.proceed();
        } catch (Throwable e) {
            LogHelper.exception("The server appeared abnormal.", e);
            if (e instanceof BaseException) {//系统内正确抛出的异常不做处理
                if (e.getMessage() != null) {
                    result = Utils.parseObject(e.getMessage(), Result.class);
                }
            } else {
                result = error;
            }
        } finally {
            if (result == null) {
                LogHelper.error("Unpredictable problem happened.");
                result = error;
            }
        }
        LogHelper.info("退出方法");
        return result;
    }

}
