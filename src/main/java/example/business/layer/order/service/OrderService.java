package example.business.layer.order.service;

import example.business.layer.order.bo.OrderBo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface OrderService {
    @Transactional
    int add(int uid, OrderBo order);

}
