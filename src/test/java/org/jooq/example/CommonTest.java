package org.jooq.example;

import example.framework.layer.util.Utils;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/7/29
 * Time:12:42
 */
public class CommonTest {
    @Test
    public void testSerializable() {
        List<String> product = new ArrayList<>();
        product.add(Utils.generateLetterString(30));
        product.add(Utils.generateLetterString(30));
        product.add(Utils.generateLetterString(30));
        product.add(Utils.generateLetterString(30));
        product.add(Utils.generateLetterString(30));
        Order order = new Order();
        order.setId(Utils.generateNumber(5));
        order.setLocation("10.258212,25.369954");
        order.setNew(false);
        order.setProduct(product);
        order.setNickname(Utils.generateLetterString(10));
        order.setOrderStatus(2);
        order.setUid(Utils.generateNumber(6));
        order.setRemark(Utils.generateLetterString(20));
        order.setUpdateTime(new Timestamp(System.currentTimeMillis()).toString());
        System.out.println("order:" + Utils.toString(order));
    }

    @lombok.Data
    class Order {
        int id;
        String location;
        List<String> product;
        boolean isNew;
        String nickname;
        int uid;
        int orderStatus;
        String remark;
        String updateTime;
    }
}
