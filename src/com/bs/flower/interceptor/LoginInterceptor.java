package com.bs.flower.interceptor;

import java.util.Map;

import com.bs.flower.entity.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 防止未登陆用户直接访问action
 * @author ben
 *
 */
public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext ctx = arg0.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		Users user = (Users) session.get("user");//登陆状态
		if (user != null) {
			return arg0.invoke();
		}
		return Action.LOGIN;	
	}
}
