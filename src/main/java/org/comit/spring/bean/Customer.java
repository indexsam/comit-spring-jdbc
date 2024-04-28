package org.comit.spring.bean;

import java.util.Date;

//import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

		int idCustomer;
		String customerName;
		String email;
		String phoneNumber;
		String password;
		String homeAddress;
		String postCode;
		
		
		//@DateTimeFormat(pattern = "yyyy-MM-dd")
		//Date createdDate;


		public int getIdCustomer() {
			return idCustomer;
		}


		public void setIdCustomer(int idCustomer) {
			this.idCustomer = idCustomer;
		}


		public String getCustomerName() {
			return customerName;
		}


		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getHomeAddress() {
			return homeAddress;
		}


		public void setHomeAddress(String homeAddress) {
			this.homeAddress = homeAddress;
		}


		public String getPostCode() {
			return postCode;
		}


		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}


		@Override
		public String toString() {
			return "Customer [idCustomer=" + idCustomer + ", customerName=" + customerName + ", email=" + email
					+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", homeAddress=" + homeAddress
					+ ", postCode=" + postCode + "]";
		}


		
		
}