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

/**
 *  
 * 
 * @author  zhang lin
 * 
 */
public class RedirectFilter implements Filter {

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
		// System.out.println(strURI);
		if ((strURI.substring(strURI.length() - 1, strURI.length()))
				.equals("/")) {
			response.sendRedirect(strURI + "index.action");
		} else {
			arg2.doFilter(request, response);
		}
		// if (request.getRequestURI().indexOf("/ftl/") == -1) {
		// arg2.doFilter(request, response);
		// } else {
		// request.getRequestDispatcher("/").forward(request, response);
		// }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
 