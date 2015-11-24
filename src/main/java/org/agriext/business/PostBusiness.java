/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.business;

import javax.json.JsonObject;

/**
 *
 * @author Phuc
 */
public class PostBusiness {
    private static PostBusiness postBusiness;
    
    public synchronized PostBusiness getInstance(){
        if(postBusiness == null)
            postBusiness = new PostBusiness();
        
        return postBusiness;
    }
    
    private PostBusiness(){}
    
    public void create(JsonObject post){
        
    }
}
