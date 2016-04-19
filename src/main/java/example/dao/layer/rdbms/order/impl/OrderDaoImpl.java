package example.dao.layer.rdbms.order.impl;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;
import example.dao.layer.rdbms.base.model.tables.records.OrderRecord;
import example.dao.layer.rdbms.order.OrderDao;
import example.framework.layer.log.LogHelper;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static example.dao.layer.rdbms.base.model.Tables.*;

/**
 * Created by Administrator on 2016/4/13.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{
    @Autowired
    DSLContext dsl;

    @Override
    public int addOne(OrderBo order) {
        OrderRecord orderRecord=dsl.newRecord(ORDER);
        orderRecord.from(order);
        int insertRet=orderRecord.insert();
        LogHelper.info("数据库操作返回值：{}",insertRet);
        return orderRecord.getOrderId();
    }

    @Override
    public UserWithOrder getOne(int uid, int orderId) {
        Record record=dsl.select(USER.MOBILE, USER.NAME, ORDER.AMOUT, ORDER.STATUS, ORDER.ORDER_TIME)
                .from(USER).innerJoin(ORDER)
                .on(ORDER.UID.eq(USER.UID))
                .where(USER.UID.eq(uid).and(ORDER.ORDER_ID.eq(orderId))).fetchOne();
        if(record==null){
            return null;
        }
        return record.into(UserWithOrder.class);
    }
}
