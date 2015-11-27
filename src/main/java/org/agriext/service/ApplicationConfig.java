/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Phuc
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.agriext.service.UserFacadeREST.class);
        resources.add(org.agriext.service.account.AccountREST.class);
        resources.add(org.agriext.service.filter.CrossOriginResourceSharingFilter.class);
        // Account proxy
        resources.add(org.agriext.service.filter.NewJaxRsFilter.class);
        // Plant proxy
        resources.add(org.agriext.service.plant.KindREST.class);
        resources.add(org.agriext.service.plant.PlantREST.class);
        // Post REST proxy
        resources.add(org.agriext.service.post.PostREST.class);
        resources.add(org.agriext.service.qa.AnswerFacadeREST.class);
        resources.add(org.agriext.service.qa.QuestionFacadeREST.class);
    }
    
}
