package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface User {

	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	boolean changePassword(String userID, String newPassword);
	boolean checkPwd(CredentialsBean cb);

}
