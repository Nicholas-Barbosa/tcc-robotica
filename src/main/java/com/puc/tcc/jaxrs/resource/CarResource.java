package com.puc.tcc.jaxrs.resource;

import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.puc.tcc.dto.CarDto;
import com.puc.tcc.dto.CarFormDTO;
import com.puc.tcc.dto.GenericResponse;
import com.puc.tcc.dto.GenericResponse.GenericResponseAttribute;
import com.puc.tcc.service.CarCrudService;

@Path("/car")
@RequestScoped
public class CarResource {

	@EJB
	private CarCrudService carService;

	@POST
	@Consumes("application/json")
	@javax.ws.rs.Produces("application/json")
	public Response save(@Valid CarFormDTO carForm) {
		CarDto savedDto = carService.save(carForm);

		GenericResponseAttribute carId = new GenericResponseAttribute("ID", savedDto.getId());
		GenericResponseAttribute carName = new GenericResponseAttribute("name", savedDto.getName());
		GenericResponseAttribute carCreatedAt = new GenericResponseAttribute("createdAt", savedDto.getCreatedAt());

		GenericResponse response = new GenericResponse(201, "Car object has been created on underlying RDBMS system.",
				Set.of(carId, carName, carCreatedAt));
		return Response.status(201).entity(response).build();
	}
}
