package example.dao.layer.rdbms.order;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface OrderDao {
    int addOne(OrderBo order);

    UserWithOrder getOne(int uid, int orderId);
}
