package example.dao.layer.rdbms.user.impl;

import example.dao.layer.rdbms.user.UserDao;
import example.framework.layer.rdbms.transaction.JooqTransactionFactory;
import org.jooq.Configuration;
import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static example.dao.layer.rdbms.base.model.Tables.USER;

/**
 * Created by Administrator on 2016/4/13.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    JooqTransactionFactory jooq;

    @Override
    public int updateOrderSum(int userId, int orderNum){
        final int[] ret = new int[1];
//        jooq.context().transaction(new TransactionalRunnable() {
//            @Override
//            public void run(Configuration configuration) throws Exception {
//                configuration.set(new TransactionProvider() {
//                    @Override
//                    public void begin(TransactionContext transactionContext) throws DataAccessException {
//                        transactionContext
//                    }
//
//                    @Override
//                    public void commit(TransactionContext transactionContext) throws DataAccessException {
//
//                    }
//
//                    @Override
//                    public void rollback(TransactionContext transactionContext) throws DataAccessException {
//
//                    }
//                });
//            }
//        });
        int a=0;
        jooq.context().transaction(configuration -> ret[0] = jooq.context().update(USER).set(USER.ORDER_SUM, USER.ORDER_SUM.add(orderNum)).where(USER.UID.eq(userId)).execute());
//        System.out.println(2/a);
        return ret[0];
    }
}
