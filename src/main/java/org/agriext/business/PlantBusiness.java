/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.agriext.data.Plant;

/**
 *
 * @author Phuc
 */
public class PlantBusiness {
    private static PlantBusiness plantBusiness;
    
    public static synchronized PlantBusiness getInstance(){
        if(plantBusiness == null)
            plantBusiness = new PlantBusiness();
        
        return plantBusiness;
    }
    
    public List<Plant> findByName(String type, String keyword)
    {
        switch (type){
            case "cmName" : 
                return lookupPlantManagerBean().findByCommonName(keyword);
            case "scName" :
                return lookupPlantManagerBean().findByScienceName(keyword);
            
        }
        return new ArrayList<>();
    }
    
    public List<Plant> findRand(int limit){
        return lookupPlantManagerBean().findRandom(limit);
    }
    
    private org.agriext.data.PlantManager lookupPlantManagerBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (org.agriext.data.PlantManager) c.lookup("java:global/agriextention-1.0/PlantTableManager!org.agriext.data.PlantManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
