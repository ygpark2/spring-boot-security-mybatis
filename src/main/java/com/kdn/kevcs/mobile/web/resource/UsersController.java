package com.kdn.kevcs.mobile.web.resource;

import com.kdn.kevcs.mobile.support.GenericUnmarshallFactory;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

@Profile("web")
@Component
@Path("/users")
@Log4j2
@Produces(MediaType.APPLICATION_XML)
public class UsersController {

	@POST
	@Path("{user-number}/auth")
	public String pos05(@PathParam("user-number") String userNumber, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		return xmlBody;
	}
}
