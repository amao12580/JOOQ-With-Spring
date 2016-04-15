package example.business.layer.order.service.impl;

import example.business.layer.order.bo.OrderBo;
import example.dao.layer.rdbms.order.OrderDao;
import example.business.layer.order.enums.Status;
import example.business.layer.order.service.OrderService;
import example.framework.layer.log.LogHelper;
import example.framework.layer.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public int add(int uid, OrderBo order) {
        order.setUid(uid);
        order.setStatus(Status.CREATE.getValue());
        order.setOrder_time(Utils.now());
        int order_id=orderDao.addOne(order);
        LogHelper.info("订单创建成功，订单号是："+order_id);
        return order_id;
    }
}
