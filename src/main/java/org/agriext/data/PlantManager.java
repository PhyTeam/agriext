/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Phuc
 */
@Stateless(name = "PlantTableManager",mappedName = "PlantTableManager")   
public class PlantManager extends GenericTable<Plant>{
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public PlantManager() {
        super(Plant.class);
    }

    public PlantManager(Class<Plant> entityClass) {
        super(entityClass);
    }



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Plant> findByCommonName(String keyword){
        return em.createQuery("SELECT a FROM Plant a WHERE a.cmname LIKE :keyword").setParameter("keyword", "%" + keyword + "%").getResultList();
    }
    
    public List<Plant> findByScienceName(String keyword){
        return em.createQuery("SELECT a FROM Plant a WHERE a.scname LIKE :keyword").setParameter("keyword", "%" + keyword + "%").getResultList();
    }
    
    public List<Plant> findRandom(int limit){
        List<Plant> e =  em.createNamedStoredProcedureQuery("rand_plant")
                .setParameter("lm", limit)
                .getResultList();
        
        System.out.println(e);
        return e;
    }
}
