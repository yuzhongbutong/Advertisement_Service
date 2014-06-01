package com.personal.ad.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.ManagerRegisterDAO;

@Service("managerRegisterDAOImpl")
public class ManagerRegisterDAOImpl implements ManagerRegisterDAO {

	@Override
	public int[] insertRegister(Connection conn, List<RegisterBean> list) {
		// TODO Auto-generated method stub
		int[] counts = null;
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_INSERT_REGISTER);
			int size = list.size();
			for (int i = 0; i < size; i++) {System.out.println(list.get(i).getUsername()+"11111111111111111111");
				ps.clearBatch();
				ps.clearParameters();
				ps.setString(1, list.get(i).getUsername());
				ps.setString(2, list.get(i).getPassword());
				ps.setString(3, list.get(i).getRealname());
				ps.setString(4, list.get(i).getTelephone());
				ps.setString(5, list.get(i).getPost());
				ps.setString(6, list.get(i).getArea());
				ps.setString(7, list.get(i).getStreet());
				ps.addBatch();
			}
			counts = ps.executeBatch();
			conn.commit();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return counts;
	}

	@Override
	public int[] updateRegister(Connection conn, List<RegisterBean> list) {
		// TODO Auto-generated method stub
		int[] counts = null;
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_UPDATE_REGISTER);
			int size = list.size();
			for (int i = 0; i < size; i++) {System.out.println(list.get(i).getUsername()+"22222222222222222--"+list.get(i).getId());
				ps.clearBatch();
				ps.clearParameters();
				ps.setString(1, list.get(i).getUsername());
				ps.setString(2, list.get(i).getPassword());
				ps.setString(3, list.get(i).getRealname());
				ps.setString(4, list.get(i).getTelephone());
				ps.setString(5, list.get(i).getPost());
				ps.setString(6, list.get(i).getArea());
				ps.setString(7, list.get(i).getStreet());
				ps.setString(8, list.get(i).getId());
				ps.addBatch();
			}
			counts = ps.executeBatch();
			conn.commit();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return counts;
	}

	@Override
	public List<RegisterBean> queryRegister(Connection conn) {
		List<RegisterBean> list = new ArrayList<RegisterBean>();
		try {
			PreparedStatement ps = conn
					.prepareStatement(FinalConstant.SQL_QUERY_REGISTER_FOR_DISPLAY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RegisterBean bean = new RegisterBean();
				bean.setId(rs.getString("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setRealname(rs.getString("realname"));
				bean.setTelephone(rs.getString("telephone"));
				bean.setPost(rs.getString("post"));
				bean.setArea(rs.getString("area"));
				bean.setStreet(rs.getString("street"));
				bean.setScore(rs.getString("score"));
				list.add(bean);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
