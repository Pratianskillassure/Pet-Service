package com.BT.Petzey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BT.Petzey.entities.Pet;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Long>{
	
	@Query(value = "select p from Pet p") //HQL/JPQL
	//Or
//	@Query(value = "select * from pet", nativeQuery = true) //SQL
	public List<Pet> getPets();
	
	//@Query(value = "select * from Pet p where p.petId=petId", nativeQuery = true)	
	@Query(value = "select p from Pet p where p.petId=:id")
    public Pet getPetDetailsByPetId(@Param (value = "id") Long petId);
	
	
	@Query(value="slect p.petStatus from pet p where p.petId=:petId", nativeQuery = true)
	public boolean getPetStatus(@Param (value = "petId")Long petId);
}
