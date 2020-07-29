package com.rasoiyya.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserLogin.class)
public abstract class UserLogin_ {

	public static volatile SingularAttribute<UserLogin, String> isParent;
	public static volatile SingularAttribute<UserLogin, Role> role;
	public static volatile SingularAttribute<UserLogin, Boolean> credentialsNonExpired;
	public static volatile SingularAttribute<UserLogin, Boolean> isActive;
	public static volatile SingularAttribute<UserLogin, Integer> userId;
	public static volatile SingularAttribute<UserLogin, Date> lastUpdatedDate;
	public static volatile SingularAttribute<UserLogin, String> password;
	public static volatile SingularAttribute<UserLogin, Date> createdDate;
	public static volatile SingularAttribute<UserLogin, String> createdBy;
	public static volatile SingularAttribute<UserLogin, String> modifiedBy;
	public static volatile SingularAttribute<UserLogin, Boolean> accountNonExpired;
	public static volatile SingularAttribute<UserLogin, String> username;
	public static volatile SingularAttribute<UserLogin, Boolean> accountNonLocked;

	public static final String IS_PARENT = "isParent";
	public static final String ROLE = "role";
	public static final String CREDENTIALS_NON_EXPIRED = "credentialsNonExpired";
	public static final String IS_ACTIVE = "isActive";
	public static final String USER_ID = "userId";
	public static final String LAST_UPDATED_DATE = "lastUpdatedDate";
	public static final String PASSWORD = "password";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ACCOUNT_NON_EXPIRED = "accountNonExpired";
	public static final String USERNAME = "username";
	public static final String ACCOUNT_NON_LOCKED = "accountNonLocked";

}

