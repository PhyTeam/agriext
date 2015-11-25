/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.agriext.data.Post;

/**
 *
 * @author Phuc
 */
public class PostBusiness {
    private static PostBusiness postBusiness;
    
    public static synchronized PostBusiness getInstance(){
        if(postBusiness == null)
            postBusiness = new PostBusiness();
        
        return postBusiness;
    }
    
    private PostBusiness(){}
    
    public void create(JsonObject post){
        
    }
    
    public List<Post> findByTitle(String keyword){
        return lookupPostManagerBean().findByTitle(keyword);
    }
    /**
     * Return top new post
     * @param type { "PO" => Ki thuat sx , "MO" => Mo hinh }
     * @param number
     * @return 
     */
    public List<Post> findNew(String type, int number){
        return lookupPostManagerBean().findTopNew(type, number);
    }
    
    
    private org.agriext.data.PostManager lookupPostManagerBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (org.agriext.data.PostManager) c.lookup("java:global/agriextention-1.0/PostTableManager!org.agriext.data.PostManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
