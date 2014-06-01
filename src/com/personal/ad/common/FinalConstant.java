package com.personal.ad.common;

public class FinalConstant {
	public static final String DB_FILE = "/config.properties";
	public static final String DB_DRIVER = "driver";
	public static final String DB_URL = "url";
	public static final String DB_USER = "user";
	public static final String DB_PASS = "pass";

	public static final String PRO_AUTHORISATION_CODE = "authorisation_code";

	public static final String JSON_KEY_STATUS = "json_status";
	public static final String JSON_VAL_SUCCESS = "S";						//成功
	public static final String JSON_VAL_STATUS_FAILURE_AC = "F-C";			//失败-授权编码错误
	public static final String JSON_VAL_STATUS_MAIL_FAILURE = "F-E";		//失败-Mail地址存在
	public static final String JSON_VAL_STATUS_NOT_MAIL_FAILURE = "F-N";	//失败-Mail地址不存在
	public static final String JSON_VAL_STATUS_INSERT_FAILURE = "F-I";		//失败-插入数据库错误

	public static final String SESSION_MAP_KEY_MAIL = "mail";
	public static final String SESSION_MAP_KEY_PASSWORD = "password";
	public static final String SESSION_MAP_KEY_PARAM_AC = "authorisationCode";

	public static final String RESULT_VAL_SUCCESS_REGISTER = "success-register";

	public static final String AC_File = "classpath*:applicationContext.xml";
	public static final String BEAN_MANAGER_DAO_IMPL = "beanManagerDAOImpl";
	public static final String BEAN_REGISTER_DAO_IMPL = "beanRegisterDAOImpl";
	public static final String BEAN_DISPLAY_LIST_DAO_IMPL = "beanDisplayListDAOImpl";

	public static final String SQL_QUERY_MANAGER = "Select count(*) from manager where username = ? and password = ? ";
	public static final String SQL_QUERY_REGISTER_WITH_MAIL = "Select count(*) from register where username = ? ";
	public static final String SQL_INSERT_REGISTER = "Insert into register (username, password, realname, telephone, post, area, street, interests) values (?, ?, ?, ?, ?, ?, ?, ?) ";
	public static final String SQL_UPDATE_REGISTER = "Update register set username = ?, password = ?, realname = ?, telephone = ?, post = ?, area = ?, street = ? where id = ? ";
	public static final String SQL_QUERY_REGISTER = "Select count(*) from register where username = ? and password = ? ";
	
	public static final String SQL_QUERY_REGISTER_FOR_DISPLAY = "Select * from register ";
}
