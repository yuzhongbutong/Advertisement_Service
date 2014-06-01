package com.personal.ad.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.service.DisplayListService;

public class DisplayListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DisplayListService displayListService;
	private List<?> list;

	public DisplayListService getDisplayListService() {
		return displayListService;
	}

	public void setDisplayListService(DisplayListService displayListService) {
		this.displayListService = displayListService;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String managerRegister() throws Exception {
		// TODO Auto-generated method stub
		list = displayListService.queryRegisterForDisplay();
		return FinalConstant.RESULT_VAL_SUCCESS_REGISTER;
	}

}
