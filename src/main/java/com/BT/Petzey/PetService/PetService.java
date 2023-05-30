package com.BT.Petzey.PetService;

import java.util.List;

import com.BT.Petzey.entities.Pet;
import com.BT.Petzey.entities.PetAppointmentDto;
import com.BT.Petzey.entities.PetDto;
import com.BT.Petzey.exception.NoInputException;
import com.BT.Petzey.exception.PetAlreadyDeactivated;
import com.BT.Petzey.exception.PetAlreadyExist;
import com.BT.Petzey.exception.PetNotFoundException;




public interface PetService {
	
	public List<Pet> getAllPets() throws PetNotFoundException;//GET
	
	public Pet addPetDetails(Pet pet) throws PetAlreadyExist;//POST
	public Pet editPetDetails(Pet pet) throws PetNotFoundException, NoInputException;//PUT
	public Pet getPetDetailsByPetId(Long id) throws PetNotFoundException, NoInputException;//GET
	public String deletePet(Long petId) throws PetNotFoundException, NoInputException;//DELETE
	public boolean updatePetStatus(Long petId) throws PetAlreadyDeactivated;//PUT	
	public List<PetDto> getAllPetDtos() throws PetNotFoundException;//GET
	
	public List<PetAppointmentDto> getAllPetsforAppointmetDto() throws PetNotFoundException;//GET
	Long getCountOfPets() throws PetNotFoundException;
	
}
