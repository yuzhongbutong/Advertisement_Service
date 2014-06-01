package com.personal.ad.dao;

import java.sql.Connection;
import java.util.List;

import com.personal.ad.bean.RegisterBean;

public interface DisplayListDAO {
	public List<RegisterBean> queryRegisterForDisplay(Connection conn);
}
