package com.BT.Petzey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.BT.Petzey.entities.Pet;
import com.BT.Petzey.entities.PetAppointmentDto;
import com.BT.Petzey.entities.PetDto;

@Mapper
public interface PetMapper {
		
		
	   @Mapping(source="pet.parentFName",target = "parentFName")
	   @Mapping(source="pet.parentLName",target = "parentLName")
		@Mapping(source="pet.petName",target = "petName")
		@Mapping(source="pet.petAge",target =  "petAge")
		@Mapping(source="pet.parentEmailId",target = "parentEmailId")
		@Mapping(source="pet.parentPhoneNumber",target = "parentPhoneNumber")
		@Mapping(source="pet.city",target = "city")
		@Mapping(source="pet.country",target = "country")
	    public PetDto convertToDto(Pet pet); //Convert Entity to Dto
	 
	   @Mapping(source="pet.petId",target = "petId")
		@Mapping(source="pet.petName",target = "petName")
		@Mapping(source="pet.petAge",target = "petAge")
	   @Mapping(source="pet.petStatus",target = "petStatus")
		@Mapping(source="pet.parentFName",target = "parentFName")
		@Mapping(source="pet.parentEmailId",target = "parentEmailId")
		@Mapping(source="pet.parentPhoneNumber",target = "parentPhoneNumber")
	   @Mapping(source="pet.state",target = "state")
	   @Mapping(source="pet.country",target = "country")
	   @Mapping(source="pet.city",target = "city")
	   @Mapping(source="pet.pincode",target = "pincode")
	   @Mapping(source="pet.avatar",target = "avatar")
		@Mapping(source="pet.petGender",target = "petGender")
		@Mapping(source="pet.biography",target = "biography")
	   @Mapping(source="pet.breed",target = "breed")
	    public PetAppointmentDto convertToAppointmentDto(Pet pet); //Convert Entity to Dto
//				//Source - Dto, target - Entity
//	    @Mapping(source = "mobileName", target = "brandName")
//	    public MobilePhone convertToEntity(MobileDto dto); //Convert Dto to Entity
	

}
