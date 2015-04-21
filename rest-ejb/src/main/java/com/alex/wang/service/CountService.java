package com.alex.wang.service;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


@Local
@Path("/")
public interface CountService {
    @GET
    @Path("count/{number}")
    Response count(@PathParam("number") String number);
}
