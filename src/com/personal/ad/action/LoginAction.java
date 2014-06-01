package com.personal.ad.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.service.RegisterService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private RegisterService registerService;
	private String authorisationCode = "";
	private String username = "";
	private String password = "";
	private Map<String, String> statusMap = new HashMap<String, String>();

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public String getAuthorisationCode() {
		return authorisationCode;
	}

	public void setAuthorisationCode(String authorisationCode) {
		this.authorisationCode = authorisationCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getStatusMap() {
		return statusMap;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		statusMap.clear();
		RegisterBean registerBean = new RegisterBean();
		registerBean.setUsername(username);
		registerBean.setPassword(password);
		int count = registerService.queryRegister(registerBean);
		if (count > 0) {
			statusMap.put(FinalConstant.JSON_KEY_STATUS,
					FinalConstant.JSON_VAL_SUCCESS);
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put(FinalConstant.SESSION_MAP_KEY_MAIL, username);
			session.put(FinalConstant.SESSION_MAP_KEY_PASSWORD, password);
		} else {
			statusMap.put(FinalConstant.JSON_KEY_STATUS,
					FinalConstant.JSON_VAL_STATUS_NOT_MAIL_FAILURE);
		}
		return INPUT;
	}
}
