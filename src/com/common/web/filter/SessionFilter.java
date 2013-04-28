package com.common.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.tool.Constants;

/**
 *  
 * 
 * @author Simen
 * 
 */
public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String strURI = request.getRequestURI();
		// 
		if (strURI.indexOf("/ht/") < 0) {
			arg2.doFilter(request, response);
			return;
		}

		Object obj = request.getSession().getAttribute(
				Constants.SESSION_YONG_HU);
		// System.out.println(obj + "  " + request.getHeader("x-requested-with")
		// +
		// "  " + strURI);

		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
