package example.framework.layer.rdbms.transaction;

import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/5/30
 * Time:12:04
 */
public class SpringExceptionTranslationExecuteListener extends DefaultExecuteListener {

    @Override
    public void exception(ExecuteContext ctx) {
        SQLException e = ctx.sqlException();

        if (e != null) {
            String name = ctx.configuration().dialect().thirdParty().springDbName();

      /* Prefer product name, if available. */
            SQLExceptionTranslator translator = (name != null)
                    ? new SQLErrorCodeSQLExceptionTranslator(name)
                    : new SQLStateSQLExceptionTranslator();

            ctx.exception(translator.translate("jOOQ", ctx.sql(), e));
        }
    }
}
