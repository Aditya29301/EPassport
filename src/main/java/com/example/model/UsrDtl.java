package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class UsrDtl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String dob;
	private String gender;
	private String presentaddress;
	private String permanentaddress;
	private String mobilenumber;
	private String email;
	private String password;
	private String confirmpassword;
	private String role;

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
//	public String getUsertype() {
//		return usertype;
//	}
//	public void setUsertype(String usertype) {
//		this.usertype = usertype;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPresentaddress() {
		return presentaddress;
	}
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UsrDtl [id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", gender=" + gender
				+ ", presentaddress=" + presentaddress + ", permanentaddress=" + permanentaddress + ", mobilenumber="
				+ mobilenumber + ", email=" + email + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ "]";
	}
	
	

}
