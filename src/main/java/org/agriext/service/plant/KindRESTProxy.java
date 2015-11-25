/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.plant;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.agriext.data.Kind;

/**
 *
 * @author Phuc
 */
public interface KindRESTProxy {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Kind entity);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Kind entity);

    @DELETE
    @Path("{id}")
    @RolesAllowed("chuyengia")
    public void remove(@PathParam("id") String id);
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kind find(@PathParam("id") String id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kind> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kind> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST();

}
