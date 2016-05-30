package example.dao.layer.rdbms.orderLog;

import example.business.layer.order.enums.Status;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/4/18
 * Time:18:30
 */
public interface OrderLogDao {
    int add(int orderId, Status status);
}
