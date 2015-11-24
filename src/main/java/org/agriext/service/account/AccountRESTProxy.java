/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.account;

import java.io.InputStream;
import java.io.Serializable;
import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.agriext.data.User;

/**
 *
 * @author Phuc
 */
@Local
public interface AccountRESTProxy extends Serializable{

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @Context HttpHeaders httpHeaders,
            @FormParam("username") String username,
            @FormParam("password") String password
    );
    
    
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greeting();
    
    
    @POST
    @Path("logout")
    public Response logout(
                    @Context HttpHeaders httpHeaders,
                    @FormParam("auth_token") String authToken);
    
    
    @POST
    @Path("signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signup(
                    User input);
    
}
