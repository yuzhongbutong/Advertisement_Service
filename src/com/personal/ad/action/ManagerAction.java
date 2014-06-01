package com.personal.ad.action;

import com.opensymphony.xwork2.ActionSupport;
import com.personal.ad.bean.ManagerBean;
import com.personal.ad.service.ManagerService;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
	private String username;
	private String password;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ManagerBean managerBean = new ManagerBean();
		managerBean.setUsername(username);
		managerBean.setPassword(password);
		int count = managerService.queryManager(managerBean);
		if (count > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
