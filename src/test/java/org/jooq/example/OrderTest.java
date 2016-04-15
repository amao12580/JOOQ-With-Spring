package org.jooq.example;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.service.OrderService;
import example.framework.layer.log.LogHelper;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jooq-spring.xml"})
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testCreate() throws Exception {
        OrderBo bo=new OrderBo();
        bo.setAmout(8958);
        int order_id=orderService.add(10010,bo);
        LogHelper.info("order_id:{}",order_id);
        Assert.assertNotEquals("订单创建失败.", order_id, 0);
    }
}
