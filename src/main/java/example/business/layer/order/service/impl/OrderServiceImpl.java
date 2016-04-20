package example.business.layer.order.service.impl;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;
import example.dao.layer.rdbms.order.OrderDao;
import example.business.layer.order.enums.Status;
import example.business.layer.order.service.OrderService;
import example.dao.layer.rdbms.orderLog.OrderLogDao;
import example.framework.layer.log.LogHelper;
import example.framework.layer.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderLogDao orderLogDao;

    /**
     *
     * 关于Transactional注解的说明：
     *
     * @Transactional标注的位置
     * @Transactional注解可以标注在类和方法上，也可以标注在定义的接口和接口方法上。
     * 如果我们在接口上标注@Transactional注解，会留下这样的隐患：因为注解不能被继承，所以业务接口中标注的@Transactional注解不会被业务实现类继承。所以可能会出现不启动事务的情况。所以，Spring建议我们将@Transaction注解在实现类上。
     * 在方法上的@Transactional注解会覆盖掉类上的@Transactional。
     *
     * http://my.oschina.net/guanzhenxing/blog/214228
     *
     * 订单创建
     *
     * @param uid 用户id
     * @param order 订单信息对象
     * @return 订单号
     */
    @Override
    @Transactional
    public int add(int uid, OrderBo order) {
        order.setUid(uid);
        order.setStatus(Status.CREATE.getValue());
        order.setOrder_time(Utils.now());
        int order_id=orderDao.addOne(order);
        orderLogDao.add(order_id,Status.CREATE);
        LogHelper.info("订单创建成功，订单号是："+order_id);
        return order_id;
    }

    @Override
    public UserWithOrder getOne(int uid, int orderId) {
        return orderDao.getOne(uid,orderId);
    }
}
