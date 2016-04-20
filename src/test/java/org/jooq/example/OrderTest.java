package org.jooq.example;

import example.controller.layer.order.OrderController;
import example.framework.layer.log.LogHelper;
import example.framework.layer.protocol.response.Result;
import example.framework.layer.util.Utils;
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
    OrderController orderController;

    @Test
    public void testCreate() throws Exception {
        Result result=orderController.add(8574l,"我是备注");
        LogHelper.info("result:{}", Utils.toString(result));
        Assert.assertNotNull("订单创建失败,返回对象为null.", result);
        int order_id=Integer.valueOf(result.getData().toString());
        LogHelper.info("order_id:{}", order_id);
        Assert.assertNotEquals("订单创建失败,订单号不正确.", order_id, 0);
    }
}
