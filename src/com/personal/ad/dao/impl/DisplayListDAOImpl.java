package com.personal.ad.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.DisplayListDAO;

public class DisplayListDAOImpl implements DisplayListDAO {
	public List<RegisterBean> queryRegisterForDisplay(Connection conn) {
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
