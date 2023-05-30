package com.BT.Petzey.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.BT.Petzey.Enum.PetGender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Default Constructor
@AllArgsConstructor //Parameterized Constructor
@Data //Getter and setter methods
@Entity //Maps as a table in DB
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long petId;
	private String petName;
	private String petAge;
	private boolean petStatus;
	private String parentFName;
	private String parentLName;
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
//	public Pet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
//	public Pet(Long petId, String petName, String petAge, boolean petStatus, String parentFName, String parentLName,
//			String parentEmailId, String parentPhoneNumber, String state, String country, String city, long pincode,
//			String avatar, String biography, PetGender petGender, String breed) {
//		super();
//		this.petId = petId;
//		this.petName = petName;
//		this.petAge = petAge;
//		this.petStatus = petStatus;
//		this.parentFName = parentFName;
//		this.parentLName = parentLName;
//		this.parentEmailId = parentEmailId;
//		this.parentPhoneNumber = parentPhoneNumber;
//		this.state = state;
//		this.country = country;
//		this.city = city;
//		this.pincode = pincode;
//		this.avatar = avatar;
//		this.biography = biography;
//		this.petGender = petGender;
//		this.breed = breed;
//	}
//
//	public String getBreed() {
//		return breed;
//	}
//	public void setBreed(String breed) {
//		this.breed = breed;
//	}
//	//private String parentlName;
////	private String address;
////	private String biography;
////	public PetGender petGender;
//	//private String Avatar;
//	public Long getPetId() {
//		return petId;
//	}
//	public void setPetId(Long petId) {
//		this.petId = petId;
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
//	public String getParentFName() {
//		return parentFName;
//	}
//	public void setParentFName(String parentFName) {
//		this.parentFName = parentFName;
//	}
//	public String getParentLName() {
//		return parentLName;
//	}
//	public void setParentLName(String parentLName) {
//		this.parentLName = parentLName;
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
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public long getPincode() {
//		return pincode;
//	}
//	public void setPincode(long pincode) {
//		this.pincode = pincode;
//	}
//	public String getAvatar() {
//		return avatar;
//	}
//	public void setAvatar(String avatar) {
//		this.avatar = avatar;
//	}
//	public String getBiography() {
//		return biography;
//	}
//	public void setBiography(String biography) {
//		this.biography = biography;
//	}
//	public PetGender getPetGender() {
//		return petGender;
//	}
//	public void setPetGender(PetGender petGender) {
//		this.petGender = petGender;
//	}
//
//}


}
