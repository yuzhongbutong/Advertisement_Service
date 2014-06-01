package com.personal.ad.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.personal.ad.bean.ManagerBean;
import com.personal.ad.common.DataBaseConnection;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.ManagerDAO;

public class ManagerService {

	public int queryManager(ManagerBean managerBean) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				ApplicationContext ac = new FileSystemXmlApplicationContext(
						FinalConstant.AC_File);
				ManagerDAO dao = (ManagerDAO) ac
						.getBean(FinalConstant.BEAN_MANAGER_DAO_IMPL);
				return dao.queryManager(conn, managerBean);
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
