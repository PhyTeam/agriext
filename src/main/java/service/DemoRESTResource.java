/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import business.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.security.auth.login.LoginException;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author Phuc
 */
@Stateless
@Path("business")
public class DemoRESTResource implements DemoRESTResourceProxy{

    @Override
    public Response login(HttpHeaders httpHeaders, String username, String password) {
        System.out.println(username + "\n");
        Authenticator authenticator = Authenticator.getInstance();
        try {
            String authToken = authenticator.login(username, password);
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("auth_token", authToken);
            JsonObject jsonObject = jsonObjectBuilder.build();
            
            return getNoCacheResponseBuilder(Response.Status.OK).entity(jsonObject.toString()).build();
        } catch (LoginException ex) {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("error", "Some thing wrong");
            JsonObject jsonObject = jsonObjectBuilder.build();
            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(jsonObject.toString()).build();
            //Logger.getLogger(DemoRESTResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * Get response builder has no cache
     * @param status
     * @return response builder has no cache
     */
    private Response.ResponseBuilder getNoCacheResponseBuilder(Response.Status status){
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setMaxAge(-1);
        cc.setMustRevalidate(true);
        
        return Response.status(status).cacheControl(cc);
    }

    @Override
    public Response greeting() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("Hello", "Phuc");
        JsonObject ret = builder.build();
        return Response.ok(ret).build();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
