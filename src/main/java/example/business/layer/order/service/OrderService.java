package example.business.layer.order.service;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface OrderService {
    int add(int uid, OrderBo order);

    UserWithOrder getOne(int uid, int orderId);
}
