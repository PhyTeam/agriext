/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.post;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.agriext.data.Post;
import org.agriext.business.AbstractFacade;

/**
 *
 * @author Phuc
 */
@Stateless
@Path("post")
public class PostREST extends AbstractFacade<Post> implements  PostRESTProxy{
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public PostREST() {
        super(Post.class);
    }

    @Override
    public void create(Post entity) {
        super.create(entity);
    }

    @Override
    public void edit(@PathParam("id") String id, Post entity) {
        super.edit(entity);
    }

    @Override
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }


    @Override
    public Post find(@PathParam("id") String id) {
        return super.find(id);
    }

    @Override
    public List<Post> findAll() {
        return super.findAll();
    }

    @Override
    public List<Post> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
