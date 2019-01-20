package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface Authentication {
	String authenticate(CredentialsBean credentialsBean);
	//boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userID);
	String changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
	//boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
}
