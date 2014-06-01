package com.personal.ad.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.personal.ad.bean.RegisterBean;
import com.personal.ad.common.DataBaseConnection;
import com.personal.ad.common.FinalConstant;
import com.personal.ad.dao.DisplayListDAO;

public class DisplayListService {
	public List<RegisterBean> queryRegisterForDisplay() {
		Connection conn = DataBaseConnection.getConnection();
		try {
			if (conn != null) {
				ApplicationContext ac = new FileSystemXmlApplicationContext(
						FinalConstant.AC_File);
				DisplayListDAO dao = (DisplayListDAO) ac
						.getBean(FinalConstant.BEAN_DISPLAY_LIST_DAO_IMPL);
				return dao.queryRegisterForDisplay(conn);
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
