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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.agriext.business.AbstractFacade;
import org.agriext.business.PlantBusiness;
import org.agriext.data.Plant;

/**
 *
 * @author Phuc
 */
@Stateless
@Path("plant")
public class PlantREST extends AbstractFacade<Plant> implements PlantRESTProxy{
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public PlantREST() {
        super(Plant.class);
    }

    @Override
    public void create(Plant entity) {
        super.create(entity);
    }

    @Override
    public void edit(@PathParam("id") String id, Plant entity) {
        super.edit(entity);
    }

    @Override
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @Override
    public Plant find(@PathParam("id") String id) {
        return super.find(id);
    }

    @Override
    public List<Plant> findAll() {
        return super.findAll();
    }

    @Override
    public List<Plant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @Override
    public List<Plant> findByName(String type, String keyword) {
        PlantBusiness pb = PlantBusiness.getInstance();
        return pb.findByName(type, keyword);
    }

    @Override
    public List<Plant> findRand(int limit) {
        System.out.println("ERROR : " + limit);
        List<Plant> ret =  PlantBusiness.getInstance().findRand(limit);
        return ret;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
