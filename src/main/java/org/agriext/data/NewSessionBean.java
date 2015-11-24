/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Phuc
 */
@Stateless(name = "UserTableManager",mappedName = "UserTableManager")
public class NewSessionBean extends GenericTable<User>{
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public NewSessionBean() {
        super(User.class);
        //init();
    }
    
    public NewSessionBean(Class<User> entityClass) {
        super(entityClass);
        //init();
    }

    void init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agriextention_agriextention_war_1.0PU");
        
        em = emf.createEntityManager();
    }
    @Override
    protected EntityManager getEntityManager() {
        System.out.println("TEST : " + em);
        return em;
    }
    
}
