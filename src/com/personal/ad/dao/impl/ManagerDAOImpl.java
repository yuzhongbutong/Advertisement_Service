package com.personal.ad.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.personal.ad.bean.ManagerBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.ManagerDAO;

public class ManagerDAOImpl implements ManagerDAO {
	public int queryManager(Connection conn, ManagerBean managerBean) {
		int count = -1;
		try {
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_QUERY_MANAGER);
			ps.setString(1, managerBean.getUsername());
			ps.setString(2, managerBean.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
