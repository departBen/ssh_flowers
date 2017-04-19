package com.bs.flower.interceptor;

import java.util.Map;

import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext ctx = arg0.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		Admin admin = (Admin) session.get("admin");//管理员登陆状态
		if (admin != null) {
			return arg0.invoke();
		}
		return Action.LOGIN;	
	}

}
