package com.kdn.kevcs.mobile.web.resource;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Log4j2
@Profile("web")
@Component
@Path("/downloads")
@Produces(MediaType.APPLICATION_XML)
public class DownloadsController {

	@SuppressWarnings("unused")
	@GET
	@Path("{chager_prd}/{prog_kind}/{version}")
	public String get03(@PathParam("chager_prd") String chager_prd, @PathParam("prog_kind") String prog_kind,
			@PathParam("version") String version) {

		return "unused!!!!!!!!!!!!!!!!!!!!!";
	}
}
