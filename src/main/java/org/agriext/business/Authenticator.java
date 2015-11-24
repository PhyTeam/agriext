/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.business;

import org.agriext.data.User;
import org.agriext.data.NewSessionBean;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.FailedLoginException;

/**
 *
 * @author Phuc
 */
public final class Authenticator {
    NewSessionBean newSessionBean = lookupNewSessionBeanBean();
    protected static Authenticator authenticator = null;
    
    private final Map<String, String> userStorage = new HashMap<>();
    
    private final Map<String,String> autherizationStorage = new HashMap<>();

    public Authenticator() {
        userStorage.put("Phuc", "123456789");
    }
    
    
    /**
     * Login method check username and password. Return authentication token
     * @param username
     * @param password
     * @return 
     * @throws javax.security.auth.login.FailedLoginException 
     * @throws javax.security.auth.login.AccountLockedException 
     */
    public String login(String username, String password) throws FailedLoginException, AccountLockedException{
        // Check user has been login
        if(autherizationStorage.containsValue(username))
            throw new AccountLockedException(username + "has login in other machine.");
        
        NewSessionBean userTable = lookupNewSessionBeanBean();
        User result = userTable.find(username);
        
        if(result != null){
            String passwordMatch = result.getPass();
            if(password.equals(passwordMatch)){
                String authToken = UUID.randomUUID().toString();
                autherizationStorage.put(authToken, username);
                return authToken;
            }
        }
        
        throw new FailedLoginException("Login has failed");
    }
    
    /**
     * Logout account
     * @param authToken Autherization Token return by login method
     * @throws GeneralSecurityException 
     */
    public void logout(String authToken) throws GeneralSecurityException{
        if(autherizationStorage.containsKey(authToken)){
            // Remove auth token
            autherizationStorage.remove(authToken);
            return;
        }
        throw new GeneralSecurityException();
    }
    
    public static synchronized Authenticator getInstance(){
        if(authenticator == null){
            authenticator = new Authenticator();
        }
        return authenticator;
    }

    private NewSessionBean lookupNewSessionBeanBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (NewSessionBean) c.lookup("java:global/agriextention-1.0/UserTableManager!data.NewSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
