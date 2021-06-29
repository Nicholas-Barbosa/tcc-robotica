package com.puc.tcc.jaxrs.resource;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.puc.tcc.service.FishService;

@Path("fish")
public class FishResource {

	@EJB
	private FishService fishService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok(fishService.findAll()).build();
	}
}
