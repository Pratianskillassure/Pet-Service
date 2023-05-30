package com.BT.Petzey.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BT.Petzey.PetService.PetService;
import com.BT.Petzey.entities.Pet;
import com.BT.Petzey.exception.NoInputException;
import com.BT.Petzey.exception.PetAlreadyDeactivated;
import com.BT.Petzey.exception.PetAlreadyExist;
import com.BT.Petzey.exception.PetNotFoundException;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*")
@RestController
@Validated
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetService service;
	
	//-------------adding new pet
	@PostMapping("/addpet")
	@Operation(summary = "To add new Pet")
	public ResponseEntity<?> addPet(@RequestBody @Valid Pet pet) throws PetAlreadyExist {
		ResponseEntity<?> response = null;
			response = new ResponseEntity<>(service.addPetDetails(pet), HttpStatus.CREATED);
		return response;
	}
//-------Getting Pet by ID----	
	@GetMapping("/petid/{id}")
	@Operation(summary = "To get Pet Details By PetId")
	public ResponseEntity<?> getById(@PathVariable(value = "id") @Valid @NotNull Long id) throws NoInputException, PetNotFoundException{
		ResponseEntity<?> response = null;
			response = new ResponseEntity<>(service.getPetDetailsByPetId(id), HttpStatus.OK);
		return response;
	}
	//Updating All pet data
	@PutMapping("/pet/edit")
	@Operation(summary = "To Edit PetDetails By PetId")
	public ResponseEntity<?> edit(@RequestBody  @Valid Pet pet) throws NoInputException, PetNotFoundException {
		ResponseEntity<?> responseEntity = null;
			responseEntity = new ResponseEntity<>(service.editPetDetails(pet), HttpStatus.OK);
		return responseEntity;
	}
	
	
	//-------Deleting Pet-----
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "To Delete Pet By PetId")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") @Valid @NotNull Long petId) throws NoInputException, PetNotFoundException{
		ResponseEntity<?> response = null;
			response = new ResponseEntity<>(service.deletePet(petId), HttpStatus.OK);
		return response;	
	}
	
	//----Retrieve all pets
		@GetMapping("/getallpets")
		@Operation(summary = "To get list of Pet")
		public ResponseEntity<?> getAllPets() throws PetNotFoundException {
			ResponseEntity<?> response = null;
	
				response = new ResponseEntity<>(service.getAllPets(), HttpStatus.OK);
	
			return response;
	}
		
	
		//-------Deactivate Pet-----
		@CrossOrigin(origins="http://localhost:4200")
		@PutMapping("/petId/{id}/update_status/")
		@Operation(summary = "Updating a pet status using Pet ID")
		public ResponseEntity<?> updateStatus(@PathVariable(value = "id") Long petId) {
			ResponseEntity<?> res = null;
			try {
				res = new ResponseEntity<>(service.updatePetStatus(petId), HttpStatus.OK);
			} catch (PetAlreadyDeactivated e) {
				res = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
			return res;
		}

		//----Retrieve all pet Dtos
		@GetMapping("/getalldtos")
		@Operation(summary = "To Get  All PetDtos")
		public ResponseEntity<?> getAllPetDto() throws PetNotFoundException {
			ResponseEntity<?> response = null;
	
				response = new ResponseEntity<>(service.getAllPetDtos(), HttpStatus.OK);
	
			return response;
	}
		//----Count all pets
		@GetMapping("/petCount")
		@Operation(summary = "To Get Count of Pets")
		public ResponseEntity<?> getCountOfPets() throws PetNotFoundException {
			ResponseEntity<?> response = null;
	
				response = new ResponseEntity<>(service.getCountOfPets(), HttpStatus.OK);
	
			return response;
	}
		//----Retrieve all pet Dtos
		@GetMapping("/getappointmentdtos")
		@Operation(summary = "To Get  All getAppointmentDtos")
		public ResponseEntity<?> getAppointmentDtos() throws PetNotFoundException {
			ResponseEntity<?> response = null;
	
				response = new ResponseEntity<>(service.getAllPetsforAppointmetDto(), HttpStatus.OK);
	
			return response;
	}
}
