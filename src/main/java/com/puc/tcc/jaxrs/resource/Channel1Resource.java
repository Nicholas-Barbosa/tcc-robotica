package com.puc.tcc.jaxrs.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.puc.tcc.service.Channe1Push;

@Path("websocket")
public class Channel1Resource {

	@Inject
	private Channe1Push pusher;

	@GET
	@Path("{message}")
	public Response sendMessage(@PathParam("message") String message) {
		pusher.send(message);
		return Response.ok().build();
	}
}
