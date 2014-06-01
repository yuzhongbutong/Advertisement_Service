package com.personal.ad.dao;

import java.sql.Connection;
import java.util.List;

import com.personal.ad.bean.RegisterBean;

public interface ManagerRegisterDAO {

	public int[] insertRegister(Connection conn, List<RegisterBean> list);

	public int[] updateRegister(Connection conn, List<RegisterBean> list);
	
	public List<RegisterBean> queryRegister(Connection conn);
}
