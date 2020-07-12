package com.rasoiyya.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserLogin.class)
public abstract class UserLogin_ {

	public static volatile SingularAttribute<UserLogin, Integer> userLoginId;
	public static volatile SingularAttribute<UserLogin, String> password;
	public static volatile SingularAttribute<UserLogin, String> userName;

	public static final String USER_LOGIN_ID = "userLoginId";
	public static final String PASSWORD = "password";
	public static final String USER_NAME = "userName";

}

