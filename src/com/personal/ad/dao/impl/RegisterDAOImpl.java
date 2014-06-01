package com.personal.ad.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.RegisterDAO;

public class RegisterDAOImpl implements RegisterDAO {
	public int queryRegisterWithMail(Connection conn, String username) {
		int count = -1;
		try {
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_QUERY_REGISTER_WITH_MAIL);
			ps.setString(1, username);
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

	@Override
	public int insertRegister(Connection conn, RegisterBean registerBean) {
		// TODO Auto-generated method stub
		int count = -1;
		try {
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_INSERT_REGISTER);
			ps.setString(1, registerBean.getUsername());
			ps.setString(2, registerBean.getPassword());
			ps.setString(3, registerBean.getRealname());
			ps.setString(4, registerBean.getTelephone());
			ps.setString(5, registerBean.getPost());
			ps.setString(6, registerBean.getArea());
			ps.setString(7, registerBean.getStreet());
			ps.setString(8, registerBean.getInterests());
			count = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int queryRegister(Connection conn, RegisterBean registerBean) {
		int count = -1;
		try {
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_QUERY_REGISTER);
			ps.setString(1, registerBean.getUsername());
			ps.setString(2, registerBean.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
