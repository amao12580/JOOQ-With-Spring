package example.framework.layer.rdbms.transaction;

import org.jooq.ConnectionProvider;
import org.jooq.exception.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/5/30
 * Time:12:04
 */
public class SpringTransactionConnectionProvider implements ConnectionProvider {
    private final DataSource ds;

    public SpringTransactionConnectionProvider(DataSource ds) {
        this.ds = ds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection acquire() {
        try {
            return DataSourceUtils.doGetConnection(ds);
        } catch (SQLException e) {
            throw new DataAccessException("Error getting connection from data source " + ds, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void release(Connection conn) {
        try {
            DataSourceUtils.doReleaseConnection(conn, ds);
        } catch (SQLException e) {
            throw new DataAccessException("Error closing connection " + conn, e);
        }
    }
}
