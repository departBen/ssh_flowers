package com.bs.flower.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.flower.entity.Admin;

/**
 * @author ben
 *防止未登陆用户直接访问jsp页面
 */
public class PermissionFilter implements Filter {
	
	public PermissionFilter() {
		
	}

	@Override
	public void destroy() {

	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		String servletPath = req.getServletPath();
		HttpSession session = req.getSession();
		
		Admin admin = (Admin) session.getAttribute("admin");
		
		if(admin == null && servletPath.equals("/admin/admin_index.jsp") ) {
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		} else{
			arg2.doFilter(arg0, arg1);
		}
	}

	

}
