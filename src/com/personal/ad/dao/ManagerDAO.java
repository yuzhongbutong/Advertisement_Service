package com.personal.ad.dao;

import java.sql.Connection;

import com.personal.ad.bean.ManagerBean;

public interface ManagerDAO {
	public int queryManager(Connection conn, ManagerBean managerBean);
}
