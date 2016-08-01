package example.framework.layer.rdbms.cache;

import example.framework.layer.log.LogHelper;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockExecuteContext;
import org.jooq.tools.jdbc.MockResult;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/8/1
 * Time:16:03
 */
public class JDBCacheProvider implements MockDataProvider {
    //Feature

    //1.缓存主动失效。1.过期.  2.脏数据(与DB不一致)，外部线程执行update，或cache的数据limit时
    //2.LRU清理。 JVM的内存有限，需要有淘汰机制
    //3.parttion存储。数据量大时，考虑按照业务属性进行分片,方便管理。例如每张表建立一个cache（这种情况下，如何应对多张表子查询）
    //4.外部维护接口。提供接口给上层维护cache
    //5.外部存错，接入redis等缓存中间件


    //简单实现，cache写入进程，map结构
    final static Map<String, Result<?>> cache = new ConcurrentHashMap<>();

    final Connection connection;


    public JDBCacheProvider(Connection connection) {
        this.connection = connection;
    }

    @Override
    public MockResult[] execute(MockExecuteContext ctx) throws SQLException {
        Result<?> result;
        ctx.bindings();
        String currentSQL = ctx.sql();
        LogHelper.info("Current SQL:" + currentSQL);
        LogHelper.info("ctx.bindings();:" + Arrays.toString(ctx.bindings()));
        if (currentSQL.contains("select ") && !currentSQL.contains("update ")) {
            LogHelper.info("这是查询语句");
            result = cache.computeIfAbsent(currentSQL, sql -> DSL.using(connection, SQLDialect.MYSQL).fetch(ctx.sql(), ctx.bindings()));
        } else {
            LogHelper.info("这不是查询语句");
            return null;
        }
        return new MockResult[]{new MockResult(result.size(), result)};
    }
}
