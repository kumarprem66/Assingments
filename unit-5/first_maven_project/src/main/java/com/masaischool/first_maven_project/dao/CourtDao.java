package com.masaischool.first_maven_project.dao;

import com.masaischool.first_maven_project.dto.Lawyer;
import com.masaischool.first_maven_project.excep.NoRecordFoundExcepion;
import com.masaischool.first_maven_project.excep.SomethingWentWrongException;

public interface CourtDao {

	
	
		Lawyer findLawyerById(int id) throws SomethingWentWrongException,NoRecordFoundExcepion;
		String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException;
		String deleteLawyerById(int id) throws SomethingWentWrongException,NoRecordFoundExcepion;
		String updateLawyerExperience(int id, int experience) throws SomethingWentWrongException,NoRecordFoundExcepion;

}
