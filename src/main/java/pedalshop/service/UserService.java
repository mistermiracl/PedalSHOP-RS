/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pedalshop.entity.UserBE;
import pedalshop.service.model.JAXResult;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("/userService")
public class UserService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserService
     */
    public UserService() {
    }

    /**
     * Retrieves representation of an instance of pedalshop.service.UserService
     * @param token Token to indentify user
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/login/{token}/{username}/{password}")
    @Produces(MediaType.TEXT_HTML)
    public JAXResult login(@PathParam(value = "token") String token) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public JAXResult register(UserBE user){
        //return new JAXResult(Util, resultMessage, user)
        return null;
    }
    /**
     * PUT method for updating or creating an instance of UserService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
}
