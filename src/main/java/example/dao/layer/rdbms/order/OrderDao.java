package example.dao.layer.rdbms.order;

import example.business.layer.order.bo.OrderBo;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface OrderDao {
    int addOne(OrderBo order);
}
