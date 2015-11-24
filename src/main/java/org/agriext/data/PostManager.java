/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Phuc
 */
@Stateless(name = "PostTableManager",mappedName = "PostTableManager")    
public class PostManager extends GenericTable<Post>{
    
    @PersistenceContext(unitName = "agriextention_agriextention_war_1.0PU")
    private EntityManager em;

    public PostManager() {
        super(Post.class);
    }

    public PostManager(Class<Post> entityClass) {
        super(entityClass);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Post> findByTitle(String keyword){
        return em.createQuery("SELECT a FROM Post a WHERE a.title LIKE :keyword").setParameter("keyword", "%" + keyword + "%").getResultList();
        
    }
    
}
