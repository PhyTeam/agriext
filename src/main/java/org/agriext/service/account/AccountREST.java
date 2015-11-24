/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.account;

import org.agriext.service.account.AccountRESTProxy;
import org.agriext.business.AccountService;
import org.agriext.data.User;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.DuplicateKeyException;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.FailedLoginException;
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
@Path("account")
public class AccountREST implements AccountRESTProxy{
    
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    @Override
    public Response login(HttpHeaders httpHeaders, String username, String password) {
        System.out.println(username + "\n");
        AccountService authenticator = AccountService.getInstance();
        try {
            String authToken = authenticator.login(username, password);
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("auth_token", authToken);
            JsonObject jsonObject = jsonObjectBuilder.build();
            
            return getNoCacheResponseBuilder(Response.Status.OK).entity(jsonObject.toString()).build();
        }
        catch(AccountLockedException ex){
            return getNoCacheResponseBuilder(Response.Status.NOT_ACCEPTABLE).build();
        }
        catch (FailedLoginException ex) {
            System.out.println(ex);
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("error", "Some thing wrong");
            JsonObject jsonObject = jsonObjectBuilder.build();
            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(jsonObject.toString()).build();
            //Logger.getLogger(AccountREST.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public Response logout(HttpHeaders httpHeaders, String authToken) {
        AccountService authenticator = AccountService.getInstance();
        System.out.println(authToken);
        try {
            authenticator.logout(authToken);
            return getNoCacheResponseBuilder(Response.Status.OK).build();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (GeneralSecurityException ex) {
            return getNoCacheResponseBuilder(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response signup(User input) {
        try{
            AccountService.getInstance().signup(input);
            return Response.status(Response.Status.CREATED).build();
        } catch(DuplicateKeyException e){
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
