package com.personal.ad.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.DataBaseConnection;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.RegisterDAO;

public class RegisterService {
	public int queryRegisterWithMail(String mail) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				ApplicationContext ac = new FileSystemXmlApplicationContext(
						FinalConstant.AC_File);
				RegisterDAO dao = (RegisterDAO) ac
						.getBean(FinalConstant.BEAN_REGISTER_DAO_IMPL);
				return dao.queryRegisterWithMail(conn, mail);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int insertRegister(RegisterBean registerBean) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				ApplicationContext ac = new FileSystemXmlApplicationContext(
						FinalConstant.AC_File);
				RegisterDAO dao = (RegisterDAO) ac
						.getBean(FinalConstant.BEAN_REGISTER_DAO_IMPL);
				return dao.insertRegister(conn, registerBean);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int queryRegister(RegisterBean registerBean) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				ApplicationContext ac = new FileSystemXmlApplicationContext(
						FinalConstant.AC_File);
				RegisterDAO dao = (RegisterDAO) ac
						.getBean(FinalConstant.BEAN_REGISTER_DAO_IMPL);
				return dao.queryRegister(conn, registerBean);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}
}
