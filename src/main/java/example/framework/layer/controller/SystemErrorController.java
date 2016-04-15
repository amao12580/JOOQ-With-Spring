package example.framework.layer.controller;

import example.framework.layer.log.LogHelper;
import example.framework.layer.protocol.response.BasicError;
import example.framework.layer.protocol.response.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统通用错误控制
 * 
 * 目的就是让前端app不要收到404、500的页面
 * 
 * @author ChengLiang
 */
@Controller
@RequestMapping("/system/error")
public class SystemErrorController{
	private static final Result ERROR404=new Result(BasicError.SYSTEM_INNER_ERROR,"404,您的请求地址存在问题.");
	private static final Result ERROR500=new Result(BasicError.SYSTEM_INNER_ERROR,"500,系统内部错误.");
	private static final Result ERROR405=new Result(BasicError.SYSTEM_INNER_ERROR,"405,系统内部错误.");
	private static final Result ERROR414=new Result(BasicError.SYSTEM_INNER_ERROR,"414,系统内部错误.");
	private static final Result ERROR505=new Result(BasicError.SYSTEM_INNER_ERROR,"505,系统内部错误.");
	private static final Result ERROR400=new Result(BasicError.SYSTEM_INNER_ERROR,"400,系统内部错误.");

	private void setHeader(HttpServletResponse response){
		response.setStatus(HttpServletResponse.SC_OK);
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
	}

	@RequestMapping(value="/404")
	@ResponseBody
	public Result E404(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E404 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR404;
	}
	
	@RequestMapping(value="/500")
	@ResponseBody
	public Result E500(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E500 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR500;
	}
	
	@RequestMapping(value="/405")
	@ResponseBody
	public Result E405(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E405 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR405;
	}
	
	@RequestMapping(value="/414")
	@ResponseBody
	public Result E414(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E414 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR414;
	}
	
	
	@RequestMapping(value="/505")
	@ResponseBody
	public Result E505(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E505 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR505;
	}
	
	@RequestMapping(value="/400")
	@ResponseBody
	public Result E400(HttpServletRequest req,HttpServletResponse response){
		LogHelper.debug("E400 is start.URI:" + req.getRequestURI());
		setHeader(response);
		return ERROR400;
	}
}
