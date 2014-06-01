package com.personal.ad.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.DataBaseConnection;
import com.personal.ad.dao.ManagerRegisterDAO;

@Service("managerRegisterService")
public class ManagerRegisterService {
	
	@Autowired
	@Qualifier("managerRegisterDAOImpl")
	private ManagerRegisterDAO managerRegisterDAOImpl;
	
	public int[] insertRegister(List<RegisterBean> list) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				return managerRegisterDAOImpl.insertRegister(conn, list);
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
		return null;
	}
	
	public int[] updateRegister(List<RegisterBean> list) {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				return managerRegisterDAOImpl.updateRegister(conn, list);
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
		return null;
	}
}
