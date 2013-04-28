package com.common.interceptor.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.context.spring.SpringDispatcherContextHolder;
import com.common.interceptor.AbstractHandlerPreparInterceptor;

public class HandlerDispatcherContextInterceptor extends
		AbstractHandlerPreparInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		SpringDispatcherContextHolder.initDispatcherContext(response);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SpringDispatcherContextHolder.resetDispatcherContext();
	}
}
