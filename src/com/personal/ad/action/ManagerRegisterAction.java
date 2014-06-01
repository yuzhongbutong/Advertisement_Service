package com.personal.ad.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;
import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.service.DisplayListService;
import com.personal.ad.service.ManagerRegisterService;

public class ManagerRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("managerRegisterService")
	private ManagerRegisterService managerRegisterService;
	private String[] checkBox;
	private String[] id;
	private String[] username;
	private String[] password;
	private String[] realname;
	private String[] telephone;
	private String[] post;
	private String[] area;
	private String[] street;
	private String[] score;
	private List<RegisterBean> list;

	public String[] getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(String[] checkBox) {
		this.checkBox = checkBox;
	}

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

	public String[] getUsername() {
		return username;
	}

	public void setUsername(String[] username) {
		this.username = username;
	}

	public String[] getPassword() {
		return password;
	}

	public void setPassword(String[] password) {
		this.password = password;
	}

	public String[] getRealname() {
		return realname;
	}

	public void setRealname(String[] realname) {
		this.realname = realname;
	}

	public String[] getTelephone() {
		return telephone;
	}

	public void setTelephone(String[] telephone) {
		this.telephone = telephone;
	}

	public String[] getPost() {
		return post;
	}

	public void setPost(String[] post) {
		this.post = post;
	}

	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}

	public String[] getStreet() {
		return street;
	}

	public void setStreet(String[] street) {
		this.street = street;
	}

	public String[] getScore() {
		return score;
	}

	public void setScore(String[] score) {
		this.score = score;
	}

	public List<RegisterBean> getList() {
		return list;
	}

	public void setList(List<RegisterBean> list) {
		this.list = list;
	}

	public String saveRegister() throws Exception {
		// TODO Auto-generated method stub
		List<RegisterBean> listInsert = new ArrayList<RegisterBean>();
		List<RegisterBean> listUpdate = new ArrayList<RegisterBean>();
		RegisterBean registerBean = null;
		if (id != null) {
			for (int i = 0; i < id.length; i++) {
				if ("-".equals(id[i])) {
					if (!"".equals(username[i])) {
						registerBean = new RegisterBean();
						registerBean.setUsername(username[i]);
						registerBean.setPassword(password[i]);
						registerBean.setRealname(realname[i]);
						registerBean.setTelephone(telephone[i]);
						registerBean.setPost(post[i]);
						registerBean.setArea(area[i]);
						registerBean.setStreet(street[i]);
						registerBean.setScore(score[i]);
						listInsert.add(registerBean);
					}
				} else {
					if ("1".equals(checkBox[i])) {
						registerBean = new RegisterBean();
						registerBean.setUsername(username[i]);
						registerBean.setPassword(password[i]);
						registerBean.setRealname(realname[i]);
						registerBean.setTelephone(telephone[i]);
						registerBean.setPost(post[i]);
						registerBean.setArea(area[i]);
						registerBean.setStreet(street[i]);
						registerBean.setScore(score[i]);
						registerBean.setId(id[i]);
						listUpdate.add(registerBean);
					}
				}
			}
			managerRegisterService.insertRegister(listInsert);
			managerRegisterService.updateRegister(listUpdate);
		}
		DisplayListService displayListService = new DisplayListService();
		list = displayListService.queryRegisterForDisplay();
		return SUCCESS;
	}

	public String deleteRegister() throws Exception {
		// TODO Auto-generated method stub
		return FinalConstant.RESULT_VAL_SUCCESS_REGISTER;
	}

}
