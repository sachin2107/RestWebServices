package com.sachin.demorest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sachin.demorest.model.Patient;

@Consumes("application/xml")
@Produces("application/xml")
@Path("/patientservice")
public interface PatientService {

	@Path("/patients")
	@GET
	List<Patient> getAllPatients();
	
	@Path("/patient/{id}")
	@GET
	Patient getPatientById(@PathParam("id")int id);
	
	@Path("/patient")
	@POST
	Response createPatient(Patient patient);
	
	@Path("/patient/{id1}")
	@DELETE
	Response deletePatient(@PathParam("id1") int id);
}
