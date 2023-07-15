package model;

public class UserData {
	private Integer userid;
	private String username;
	private String password;
	private String name;
	private Integer account_number;
	private String ifsc;
	private String pan_card;
	private Integer phone_number;
	private String emailid;
	private Integer current_balance;
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	public UserData(Integer userid, String username, String password, String name, Integer account_number, String ifsc,
			String pan_card, Integer phone_number, String emailid, Integer current_balance) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.account_number = account_number;
		this.ifsc = ifsc;
		this.pan_card = pan_card;
		this.phone_number = phone_number;
		this.emailid = emailid;
		this.current_balance = current_balance;
	}
	/**
	 * @param userid the userid to set
	 */
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the account_number
	 */
	public Integer getAccount_number() {
		return account_number;
	}
	/**
	 * @param account_number the account_number to set
	 */
	public void setAccount_number(Integer account_number) {
		this.account_number = account_number;
	}
	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}
	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	/**
	 * @return the pan_card
	 */
	public String getPan_card() {
		return pan_card;
	}
	/**
	 * @param pan_card the pan_card to set
	 */
	public void setPan_card(String pan_card) {
		this.pan_card = pan_card;
	}
	/**
	 * @return the phone_number
	 */
	public Integer getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the current_balance
	 */
	public Integer getCurrent_balance() {
		return current_balance;
	}
	/**
	 * @param current_balance the current_balance to set
	 */
	public void setCurrent_balance(Integer current_balance) {
		this.current_balance = current_balance;
	}
	
	
}
