package com.kdn.kevcs.mobile.web.resource;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Log4j2
@Profile("web")
@Component
@Path("/prices")
@Produces(MediaType.APPLICATION_XML)
public class PricesController {

    @GET
    @Path("{charger_type}/{version}")
    public String get02(@PathParam("charger_type") int chargerType, @PathParam("version") String version) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(chargerType);
		log.info(version);
		log.info("--------------------------- xml body -----------------------------");

		return "test";
    }
    
}


