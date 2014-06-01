package com.personal.ad.dao;

import java.sql.Connection;

import com.personal.ad.bean.RegisterBean;

public interface RegisterDAO {
	public int queryRegisterWithMail(Connection conn, String mail);

	public int insertRegister(Connection conn, RegisterBean registerBean);

	public int queryRegister(Connection conn, RegisterBean registerBean);
}
