package com.personal.ad.common;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DeviceInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> session = arg0.getInvocationContext()
				.getParameters();
		String param = ((String[]) session
				.get(FinalConstant.SESSION_MAP_KEY_PARAM_AC))[0];
		if (GeneralOperation
				.getProperties(FinalConstant.PRO_AUTHORISATION_CODE).equals(
						param)) {
			return arg0.invoke();
		} else {
			jsonObject.put(FinalConstant.JSON_KEY_STATUS,
					FinalConstant.JSON_VAL_STATUS_FAILURE_AC);
		}
		out.print(jsonObject);
		out.flush();
		return null;
	}
}
