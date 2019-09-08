package com.sachin.demorest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientNotFoundExceptionMapper implements ExceptionMapper<PatientNotFoundException>{

	@Override
	public Response toResponse(PatientNotFoundException exception) {
		return Response.serverError().entity("Patien Not Found in DB....").type(MediaType.APPLICATION_JSON).build();
	}

}
