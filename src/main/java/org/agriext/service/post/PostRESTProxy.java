/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.post;

import java.util.List;
import javax.ejb.Local;
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
import org.agriext.data.Post;

/**
 *
 * @author Phuc
 */
@Local
public interface PostRESTProxy {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Post entity);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Post entity);

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post find(@PathParam("id") String id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST();
}
