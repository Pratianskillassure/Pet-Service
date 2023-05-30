package com.BT.Petzey.entities;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetDto {
	 	@NotNull(message="Pet name should not be null")
	    @Size(min=3,message="Pet name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Pet name")
	    private String petName;
	    
	    @NotNull(message="parent first name should not be null")
	    @Size(min=3,message="parent first name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Pet name")
	    private String parentFName;
	    
	    
	    @NotNull(message="parent last name should not be null")
	    @Size(min=3,message="parent last name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid parentL name")
	    private String parentLName;
	    
	    @NotNull(message="parent last name should not be null")
	    @Size(min=3,message="parent last name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid parentL name")
		private String petAge;

	    //private String Address;
	    
	    @NotNull(message="Parent Email should not be null")
	    @Email(message="enter valid email id")
	    private String parentEmailId;
	    
	    @NotNull(message="parent phone number should not be null")
	    @Size(min=10,max=12,message="parent phone number is too short or too long")
	    @Pattern(regexp="^[0-9]*$",message = "Invalid parent phone Number")
	    private String parentPhoneNumber;
	    
	    @NotNull(message="country name should not be null")
	    @Size(min=3,message="parent last name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid parentL name")
	    private String country;
	    
	    @NotNull(message="city name should not be null")
	    @Size(min=3,message="parent last name is too short")
	    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid parentL name")
		private String city;
}

