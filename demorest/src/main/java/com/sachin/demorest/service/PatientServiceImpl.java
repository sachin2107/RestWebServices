package com.sachin.demorest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sachin.demorest.model.Patient;

@Service
public class PatientServiceImpl implements PatientService{

	Map patientMap = new HashMap<>();
	
	public PatientServiceImpl() {
		init();
	}

	public void init() {
		Patient patient = new Patient();
		patient.setId(1);
		patient.setName("sachin");
		patientMap.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		Collection values = patientMap.values();
		List<Patient> listOfPatients = new ArrayList(values);
		return listOfPatients;
	}

	@Override
	public Response createPatient(Patient patient) {
		int patientId = patientMap.size();
		patient.setId(++patientId);
		patientMap.put(patient.getId(), patient);
		return Response.accepted().build();
	}

	@Override
	public Response deletePatient(int id) {
		Patient currentPatient = (Patient)patientMap.get(id);
		if(currentPatient != null)
		{
			patientMap.remove(id);
			return Response.ok().build();
		}else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@Override
	public Patient getPatientById(int id) {
		Patient patient = (Patient)patientMap.get(id);
		return patient;
	}

	
}
