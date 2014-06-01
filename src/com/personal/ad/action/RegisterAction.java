package com.personal.ad.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.service.RegisterService;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private RegisterService registerService;
	private String authorisationCode = "";
	private String username = "";
	private String password = "";
	private String realname = "";
	private String telephone = "";
	private String post = "";
	private String area = "";
	private String street = "";
	private String interests = "";
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Map<String, String> getStatusMap() {
		return statusMap;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		statusMap.clear();
		if (registerService.queryRegisterWithMail(username) > 0) {
			statusMap.put(FinalConstant.JSON_KEY_STATUS,
					FinalConstant.JSON_VAL_STATUS_MAIL_FAILURE);
		} else {
			RegisterBean registerBean = new RegisterBean();
			registerBean.setUsername(username);
			registerBean.setPassword(password);
			registerBean.setRealname(realname);
			registerBean.setTelephone(telephone);
			registerBean.setPost(post);
			registerBean.setArea(area);
			registerBean.setStreet(street);
			registerBean.setInterests(interests);
			int count = registerService.insertRegister(registerBean);
			if (count > 0) {
				statusMap.put(FinalConstant.JSON_KEY_STATUS,
						FinalConstant.JSON_VAL_SUCCESS);
			} else {
				statusMap.put(FinalConstant.JSON_KEY_STATUS,
						FinalConstant.JSON_VAL_STATUS_INSERT_FAILURE);
			}
		}
		return INPUT;
	}
}
