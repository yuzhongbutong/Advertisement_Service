package com.personal.ad.common;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ServiceInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		if (session.get(FinalConstant.SESSION_MAP_KEY_MAIL) != null
				&& session.get(FinalConstant.SESSION_MAP_KEY_PASSWORD) != null) {
			return arg0.invoke();
		}
		return Action.LOGIN;
	}
}
