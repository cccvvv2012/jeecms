package com.common.interceptor.system;

/**
 * 验证用户登陆拦截器
 */
// @Aspect
// @Component
public class LoginInterceptor {// extends HandlerInterceptorAdapter {

	// @Pointcut("execution(public * com.login.dao..*.*(..))")
	public void myExecution() {
	};

	// @Before("myExecution()")
	public void StartUserLog() {
		System.out.println("执行了com.senlo.analyze.core.common.dao.Impl核心操作层 ^_^ ");
	}

	// within target是spring自带的，我们不用理
	/*
	 * @Around("myExecution()") //Throwable比exception还要大 public void
	 * aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
	 * System.out.println("method around start"); pjp.proceed();
	 * System.out.println("method around end"); }
	 * 
	 * @AfterReturning("myExecution()") public void Over() {
	 * System.out.println("执行完，返回后执行的方法"); }
	 * 
	 * @AfterThrowing("myExecution()") public void Exception() {
	 * System.out.println("抛出异常执行的方法"); }
	 * 
	 * @After("myExecution()") public void After() {
	 * System.out.println("相当于是finally执行需要执行的方法"); }
	 */
	// @Override
	/*
	 * public boolean preHandle(HttpServletRequest request, HttpServletResponse
	 * response, Object handler) throws Exception {
	 * 
	 * // 如果session中没有user对象 if (null == request.getSession()
	 * .getAttribute(WebConstants.CURRENT_USER)) { String requestedWith =
	 * request.getHeader("x-requested-with"); // ajax请求 if (requestedWith !=
	 * null && "XMLHttpRequest".equals(requestedWith)) {
	 * response.setHeader("session-status", "timeout");
	 * response.getWriter().print(WebConstants.TIME_OUT); } else { // 普通页面请求
	 * response.sendRedirect(request.getContextPath() + "/"); } return false; }
	 * return true;
	 * 
	 * }
	 */
}
