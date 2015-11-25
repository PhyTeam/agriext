/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.plant;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.agriext.data.Plant;

/**
 *
 * @author Phuc
 */
@Local
public interface PlantRESTProxy {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Plant entity);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Plant entity);

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plant find(@PathParam("id") String id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plant> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plant>findByName(@QueryParam("type") String type, @QueryParam("keyword") String keyword);
    
    @GET
    @Path("rand")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plant>findRand(@QueryParam("limit") int limit);
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST();
}
