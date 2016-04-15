package example.controller.layer.order;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.service.OrderService;
import example.framework.layer.controller.BasicController;
import example.framework.layer.log.LogHelper;
import example.framework.layer.protocol.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/order")
public class OrderController extends BasicController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Result add(Long amount) {
		LogHelper.info("amount:{}",amount);
		return super.safetyExcute(amount);
	}

	@Override
	public Result excute(Object... objects) {
		LogHelper.info("excute is start.");
		OrderBo bo=new OrderBo();
		bo.setAmout((Long)objects[0]);
		int orderId=orderService.add(185147,bo);
		return new Result(orderId);
	}
}
