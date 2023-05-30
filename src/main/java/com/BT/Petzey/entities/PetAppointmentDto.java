package com.BT.Petzey.entities;

import com.BT.Petzey.Enum.PetGender;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetAppointmentDto {
	
	//private Long petId;
	private Long petId;
	private String petName;
	private String petAge;
	private boolean petStatus;
	private String parentFName;
//	private String parentLName;
	private String parentEmailId;
	private String parentPhoneNumber;
	private String state;
	private String country;
	private String city;
	private long pincode;
	private String avatar;
	private String biography;
	private PetGender petGender;
	private String breed;

//	public PetAppointmentDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public String getPetName() {
//		return petName;
//	}
//	public void setPetName(String petName) {
//		this.petName = petName;
//	}
//	public String getPetAge() {
//		return petAge;
//	}
//	public void setPetAge(String petAge) {
//		this.petAge = petAge;
//	}
//	public boolean isPetStatus() {
//		return petStatus;
//	}
//	public void setPetStatus(boolean petStatus) {
//		this.petStatus = petStatus;
//	}
//	public String getParentfName() {
//		return parentfName;
//	}
//	public void setParentfName(String parentfName) {
//		this.parentfName = parentfName;
//	}
//	public String getParentlName() {
//		return parentlName;
//	}
//	public void setParentlName(String parentlName) {
//		this.parentlName = parentlName;
//	}
//	public String getParentEmailId() {
//		return parentEmailId;
//	}
//	public void setParentEmailId(String parentEmailId) {
//		this.parentEmailId = parentEmailId;
//	}
//	public String getParentPhoneNumber() {
//		return parentPhoneNumber;
//	}
//	public void setParentPhoneNumber(String parentPhoneNumber) {
//		this.parentPhoneNumber = parentPhoneNumber;
//	}
//	public PetGender getPetGender() {
//		return petGender;
//	}
//	public void setPetGender(PetGender petGender) {
//		this.petGender = petGender;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getBiography() {
//		return biography;
//	}
//	public void setBiography(String biography) {
//		this.biography = biography;
//	}
	
//	private String state;
//	private String country;
//	private String city;
//	private long pincode;
	//private String Avatar;
}
