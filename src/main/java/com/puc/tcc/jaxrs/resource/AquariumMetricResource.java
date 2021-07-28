package com.puc.tcc.jaxrs.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.dto.AquariumMetricForm;
import com.puc.tcc.dto.NotFoundSerializable;
import com.puc.tcc.service.AquariumMetricService;

@Path("aquariumMetric")
public class AquariumMetricResource {

	private AquariumMetricService service;

	@Inject
	public AquariumMetricResource(AquariumMetricService service) {
		super();
		this.service = service;
	}

	@GET
	@Path("/last")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lastMetric() {
		return Response.ok(service.findLastMetric()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) {
		Optional<AquariumMetricDTO> maybeAquarium = service.findById(id);
		if (maybeAquarium.isPresent()) {
			return Response.ok(maybeAquarium.get()).build();
		}
		return Response.status(404)
				.entity(NotFoundSerializable.of("Métrica não encotrada!Último ID: " + service.findAll().size()))
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		return Response.ok(service.findAll()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveMetric(AquariumMetricForm form) {
		service.save(form);
		return Response.status(201).build();
	}
}
