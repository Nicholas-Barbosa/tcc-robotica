package com.puc.tcc.jaxrs;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.puc.tcc.service.FishService;

@Path("fish")
public class FishResource {

	@EJB
	private FishService fishService;

	@GET
	public Response get() {
		fishService.findAll();
		return Response.ok().build();
	}
}
