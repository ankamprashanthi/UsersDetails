package org.studyeasy.entity;

public class user {

	
		private int userid;
		private String username;
		private String email;
		
		public user(int userid, String username, String email) {
			super();
			this.userid = userid;
			this.username = username;
			this.email = email;
		}
		public user(String username, String email) {
			super();
			
			this.username = username;
			this.email = email;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	

	

}
