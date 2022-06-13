package ks43team01.dto;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String userContact;
	private String userEmail;
	private String userStatus;///업데이트이용?	
	private String userArea;
	private String userPoint;///포인트총액???	
	private String userRating;//회원등급자동생성
	private String userRreDate;
	private String userUpDate;
	private String userLevel;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userContact=");
		builder.append(userContact);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userStatus=");
		builder.append(userStatus);
		builder.append(", userArea=");
		builder.append(userArea);
		builder.append(", userPoint=");
		builder.append(userPoint);
		builder.append(", userRating=");
		builder.append(userRating);
		builder.append(", userRreDate=");
		builder.append(userRreDate);
		builder.append(", userUpDate=");
		builder.append(userUpDate);
		builder.append(", userLevel=");
		builder.append(userLevel);
		builder.append("]");
		return builder.toString();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public String getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(String userPoint) {
		this.userPoint = userPoint;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	public String getUserRreDate() {
		return userRreDate;
	}
	public void setUserRreDate(String userRreDate) {
		this.userRreDate = userRreDate;
	}
	public String getUserUpDate() {
		return userUpDate;
	}
	public void setUserUpDate(String userUpDate) {
		this.userUpDate = userUpDate;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	
	
}
