package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
@NamedQuery(name="UserLogin.findAll", query="SELECT u FROM UserLogin u")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public UserLogin(){
	}
	
	public UserLogin(UserLogin user) {
		this.userId = user.getUserId();
		this.createdBy = user.getCreatedBy();
		this.createdDate = user.getCreatedDate();
		this.isActive = user.getIsActive();
		this.isParent = user.getIsParent();
		this.lastUpdatedDate = user.getLastUpdatedDate();
		this.modifiedBy = user.getModifiedBy();
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.accountNonExpired = user.isAccountNonExpired();
		this.credentialsNonExpired = user.isAccountNonExpired();
		this.accountNonLocked = user.isAccountNonLocked();
		this.role = user.getRoles();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="is_active")
	private boolean isActive;

	@Column(name="is_parent")
	private String isParent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	private String password;

	private String username;

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;
    
    @ManyToOne
	@JoinColumn(name="user_role_id")
	private Role role;
    
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	/*//bi-directional many-to-one association to ForgetPasswordHistory
	@OneToMany(mappedBy="userLogin")
	private List<ForgetPasswordHistory> forgetPasswordHistories;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="userLogin")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="userLogin")
	private List<Person> persons;

	//bi-directional many-to-one association to ReferralCode
	@OneToMany(mappedBy="userLogin")
	private List<ReferralCode> referralCodes;

	//bi-directional many-to-one association to ReferralCodeLog
	@OneToMany(mappedBy="userLogin1")
	private List<ReferralCodeLog> referralCodeLogs1;

	//bi-directional many-to-one association to ReferralCodeLog
	@OneToMany(mappedBy="userLogin2")
	private List<ReferralCodeLog> referralCodeLogs2;
*/
	//bi-directional many-to-one association to Role

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsParent() {
		return this.isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRoles() {
		return role;
	}

	public void setRoles(Role roles) {
		this.role = roles;
	}

	/*public List<ForgetPasswordHistory> getForgetPasswordHistories() {
		return this.forgetPasswordHistories;
	}

	public void setForgetPasswordHistories(List<ForgetPasswordHistory> forgetPasswordHistories) {
		this.forgetPasswordHistories = forgetPasswordHistories;
	}*/

	/*public ForgetPasswordHistory addForgetPasswordHistory(ForgetPasswordHistory forgetPasswordHistory) {
		getForgetPasswordHistories().add(forgetPasswordHistory);
		forgetPasswordHistory.setUserLogin(this);

		return forgetPasswordHistory;
	}*/

	/*public ForgetPasswordHistory removeForgetPasswordHistory(ForgetPasswordHistory forgetPasswordHistory) {
		getForgetPasswordHistories().remove(forgetPasswordHistory);
		forgetPasswordHistory.setUserLogin(null);

		return forgetPasswordHistory;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}*/

	/*public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUserLogin(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUserLogin(null);

		return notification;
	}*/

	/*public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}*/

	/*public Person addPerson(Person person) {
		getPersons().add(person);
		person.setUserLogin(this);

		return person;
	}*/

	/*public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setUserLogin(null);

		return person;
	}

	public List<ReferralCode> getReferralCodes() {
		return this.referralCodes;
	}

	public void setReferralCodes(List<ReferralCode> referralCodes) {
		this.referralCodes = referralCodes;
	}*/

	/*public ReferralCode addReferralCode(ReferralCode referralCode) {
		getReferralCodes().add(referralCode);
		referralCode.setUserLogin(this);

		return referralCode;
	}

	public ReferralCode removeReferralCode(ReferralCode referralCode) {
		getReferralCodes().remove(referralCode);
		referralCode.setUserLogin(null);

		return referralCode;
	}

	public List<ReferralCodeLog> getReferralCodeLogs1() {
		return this.referralCodeLogs1;
	}

	public void setReferralCodeLogs1(List<ReferralCodeLog> referralCodeLogs1) {
		this.referralCodeLogs1 = referralCodeLogs1;
	}
*/
	/*public ReferralCodeLog addReferralCodeLogs1(ReferralCodeLog referralCodeLogs1) {
		getReferralCodeLogs1().add(referralCodeLogs1);
		referralCodeLogs1.setUserLogin1(this);

		return referralCodeLogs1;
	}

	public ReferralCodeLog removeReferralCodeLogs1(ReferralCodeLog referralCodeLogs1) {
		getReferralCodeLogs1().remove(referralCodeLogs1);
		referralCodeLogs1.setUserLogin1(null);

		return referralCodeLogs1;
	}*/

	/*public List<ReferralCodeLog> getReferralCodeLogs2() {
		return this.referralCodeLogs2;
	}

	public void setReferralCodeLogs2(List<ReferralCodeLog> referralCodeLogs2) {
		this.referralCodeLogs2 = referralCodeLogs2;
	}*/

	/*public ReferralCodeLog addReferralCodeLogs2(ReferralCodeLog referralCodeLogs2) {
		getReferralCodeLogs2().add(referralCodeLogs2);
		referralCodeLogs2.setUserLogin2(this);

		return referralCodeLogs2;
	}

	public ReferralCodeLog removeReferralCodeLogs2(ReferralCodeLog referralCodeLogs2) {
		getReferralCodeLogs2().remove(referralCodeLogs2);
		referralCodeLogs2.setUserLogin2(null);

		return referralCodeLogs2;
	}*/



}