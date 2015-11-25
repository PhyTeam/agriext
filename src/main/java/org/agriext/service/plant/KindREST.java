/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service.plant;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.agriext.business.AbstractFacade;
import org.agriext.data.Kind;

/**
 *
 * @author Phuc
 */
@Stateless
@Path("plant.kind")
public class KindREST extends AbstractFacade<Kind> implements  KindRESTProxy{
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public KindREST() {
        super(Kind.class);
    }


    @Override
    public void create(Kind entity) {
        super.create(entity);
    }

    @Override
    public void edit(@PathParam("id") String id, Kind entity) {
        super.edit(entity);
    }

    @Override
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @Override
    public Kind find(@PathParam("id") String id) {
        return super.find(id);
    }

    @Override
    public List<Kind> findAll() {
        return super.findAll();
    }


    @Override
    public List<Kind> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
