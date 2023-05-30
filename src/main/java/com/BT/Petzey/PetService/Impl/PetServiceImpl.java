package com.BT.Petzey.PetService.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BT.Petzey.PetService.PetService;
import com.BT.Petzey.entities.Pet;
import com.BT.Petzey.entities.PetAppointmentDto;
import com.BT.Petzey.entities.PetDto;
import com.BT.Petzey.exception.NoInputException;
import com.BT.Petzey.exception.PetAlreadyDeactivated;
import com.BT.Petzey.exception.PetAlreadyExist;
import com.BT.Petzey.exception.PetNotFoundException;
import com.BT.Petzey.mapper.PetMapper;
import com.BT.Petzey.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {
	
	private static final Logger log = LoggerFactory.getLogger(PetServiceImpl.class);
	
	@Autowired
	private PetRepository petRepo;//Pet
	@Autowired
	private PetMapper petmapper;
	
	
	@Override
	public List<Pet> getAllPets() throws PetNotFoundException {
		log.info("Veiwing All pets");
		List<Pet> pets = null;
		
		pets = petRepo.findAll();
		if (pets.isEmpty()) {
			log.error("There is no Pet in List...");
			throw new PetNotFoundException("There is no Pet in List...");
		}
		return pets;
	}

	
	@Override
	public Pet addPetDetails(Pet pet) throws PetAlreadyExist {
		log.info("Adding new  pet");
			Pet petToSave = null;
			if (petRepo.existsById(pet.getPetId())) {
				log.error("Pet AlreadyExist");
				throw new PetAlreadyExist("Pet AlreadyExist");
			}
			log.info("saving new pet");
			petToSave = petRepo.save(pet);
			return petToSave;
	}

	@Override
	public Pet editPetDetails(Pet pet) throws PetNotFoundException, NoInputException {
		log.info("editing pet");
		if(Long.valueOf(pet.getPetId())==0) {
            log.error("petid id not entered");
            throw new NoInputException("Enter a department Id: ");
		}
		if (!petRepo.existsById(pet.getPetId())) {
			log.error("Pet Details Not Found.");
			throw new PetNotFoundException("Pet Details Not Found.");
		}
		log.info("saving pet");
		
		petRepo.save(pet);
		return pet;
	}
	//-----------------------------------------Get Pet by Id
	@Override
	public Pet getPetDetailsByPetId(Long petId) throws PetNotFoundException, NoInputException {
		log.info("Veiwing pet");
		
		Pet pet=petRepo.getPetDetailsByPetId(petId);
		if(Long.valueOf(pet.getPetId())==0) {
            log.error("petid id not entered");
            throw new NoInputException("Enter a department Id: ");
		}
		if(!petRepo.existsById(petId)) {
			log.error("Pet Details does not exist by this Id");
			throw new PetNotFoundException("Pet Details does not exist by this Id");
		}
		return pet;
	}
	//-----------------------------------------Delete Pet by Id
	@Override
	public String deletePet(Long petId) throws PetNotFoundException, NoInputException {
		log.info("Delete pet");
		Pet pet=petRepo.getPetDetailsByPetId(petId);
		if(Long.valueOf(pet.getPetId())==0) {
            log.error("petid id not entered");
            throw new NoInputException("Enter a department Id: ");
		}
		if(!petRepo.existsById(petId)) {
			log.error("Pet by this Id does not exists");
			throw new PetNotFoundException("Pet by this Id does not exists");
		}
		log.info("Delete pet"+petRepo.getById(petId));
		petRepo.deleteById(petId);
		
		return "pet is deleted succesfully" ;
	}
	//-----------------------------------------Deactivate Pet by Id
	@Override
	public boolean updatePetStatus(Long petId) throws PetAlreadyDeactivated {
		log.info("Deactivate pet");
		boolean isActive=true;
		
		Pet pet=petRepo.getPetDetailsByPetId(petId);
		
		if(pet.isPetStatus()) {
			pet.setPetStatus(false);
			petRepo.save(pet);
			isActive=false;
		}
		else {
			log.error("deactivated status");
			pet.setPetStatus(true);
			log.info("saving updated pet status");
			petRepo.save(pet);
			isActive=true;
		}
	return isActive;
		
}


	@Override
	public List<PetDto> getAllPetDtos() throws PetNotFoundException {
		// TODO Auto-generated method stub
		List<PetDto> petDtos = new ArrayList<PetDto>();
		List<Pet> petDetails = new ArrayList<>();
		PetDto petDto = new PetDto();
		log.info("Veiwing All pets");
		petDetails = petRepo.findAll();
		for(Pet pet:petDetails) {
			petDto=petmapper.convertToDto(pet);
			petDtos.add(petDto);	
			
		}
		if (petDtos.isEmpty()) {
			log.error("There is no Pet in List...");
			throw new PetNotFoundException("There is no Pet in List...");
		}
		return petDtos;
	}
	
	@Override
	public Long getCountOfPets() throws PetNotFoundException {
		long pets = 0;
		log.info("Counting number of pets");
		pets = petRepo.count();
//		if (pets==0) {
//			log.error("There is no Pet in Pet Table...");
//			throw new PetNotFoundException("There is no Pet in Pet Table...");
//		}
		return pets;
	}


	@Override
	public List<PetAppointmentDto> getAllPetsforAppointmetDto() throws PetNotFoundException {
		// TODO Auto-generated method stub
				List<PetAppointmentDto> petAppointmentDtos = new ArrayList<PetAppointmentDto>();
				List<Pet> petDetails = new ArrayList<>();
				PetAppointmentDto petDto = new PetAppointmentDto();
				log.info("Veiwing All pets");
				petDetails = petRepo.findAll();
				for(Pet pet:petDetails) {
					petDto=petmapper.convertToAppointmentDto(pet);
					petAppointmentDtos.add(petDto);	
					
				}
				if (petAppointmentDtos.isEmpty()) {
					log.error("There is no Pet in List...");
					throw new PetNotFoundException("There is no Pet in List...");
				}
				return petAppointmentDtos;
	}
}
