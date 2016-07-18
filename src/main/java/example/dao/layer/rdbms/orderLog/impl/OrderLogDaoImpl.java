package example.dao.layer.rdbms.orderLog.impl;

import example.business.layer.order.enums.Status;
import example.dao.layer.rdbms.base.model.tables.records.OrderLogRecord;
import example.dao.layer.rdbms.orderLog.OrderLogDao;
import example.framework.layer.log.LogHelper;
import example.framework.layer.rdbms.transaction.JooqTransactionFactory;
import example.framework.layer.util.Utils;
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
//        LogHelper.info("---------------------------------------------------");
//        //混合类型的insert对象，在内部进行按类型分组后，每组进行一次batchInsert
//        List list = new ArrayList<>();
//        OrderLogRecord orderLogRecord = jooq.context().newRecord(ORDER_LOG);
//        orderLogRecord.setOrderId(orderId);
//        orderLogRecord.setStatus(status.getValue());
//        orderLogRecord.setChangeTime(Utils.nowTime());
//
//
//        OrderLogRecord orderLogRecord2 = jooq.context().newRecord(ORDER_LOG);
//        orderLogRecord2.setOrderId(orderId);
//        orderLogRecord2.setStatus((byte) 5);
//        orderLogRecord2.setChangeTime(Utils.nowTime());
//
//        OrderRecord orderRecord = jooq.context().newRecord(ORDER);
//        orderRecord.setUid(15896);
//        orderRecord.setAmout(14736l);
//        orderRecord.setOrderTime(Utils.nowTime());
//        orderRecord.setRemark("232323232323");
//        orderRecord.setStatus((byte) 3);
//
//        list.add(orderLogRecord);
//        list.add(orderLogRecord2);
//        list.add(orderRecord);
//
//        int[] result = jooq.context().batchInsert(list).execute();
//        LogHelper.info("*************************************************************");
//        return result.length;


        OrderLogRecord orderLogRecord = jooq.context().newRecord(ORDER_LOG);
        orderLogRecord.setOrderId(orderId);
        orderLogRecord.setStatus(status.getValue());
        orderLogRecord.setChangeTime(Utils.nowTime());
        int insertRet = orderLogRecord.insert();
        LogHelper.info("数据库操作返回值：{}", insertRet);
        return orderLogRecord.getId();
    }
}
