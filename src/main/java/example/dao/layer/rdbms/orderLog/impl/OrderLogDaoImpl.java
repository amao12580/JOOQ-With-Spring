package example.dao.layer.rdbms.orderLog.impl;

import example.business.layer.order.enums.Status;
import example.dao.layer.rdbms.base.model.tables.records.OrderLogRecord;
import example.dao.layer.rdbms.orderLog.OrderLogDao;
import example.framework.layer.log.LogHelper;
import example.framework.layer.rdbms.transaction.JooqTransactionFactory;
import example.framework.layer.util.Utils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static example.dao.layer.rdbms.base.model.Tables.ORDER_LOG;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:18:31
 */
@Repository
public class OrderLogDaoImpl implements OrderLogDao {
    @Autowired
    JooqTransactionFactory jooq;

    @Override
    public int add(int orderId, Status status) {
        OrderLogRecord orderLogRecord = jooq.context().newRecord(ORDER_LOG);
        orderLogRecord.setOrderId(orderId);
        orderLogRecord.setStatus(status.getValue());
        orderLogRecord.setChangeTime(Utils.nowTime());
        int insertRet = orderLogRecord.insert();
        LogHelper.info("数据库操作返回值：{}", insertRet);
        return orderLogRecord.getId();
    }
}
