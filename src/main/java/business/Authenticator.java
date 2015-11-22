/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.security.auth.login.LoginException;

/**
 *
 * @author Phuc
 */
public final class Authenticator {
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
     * @throws javax.security.auth.login.LoginException 
     */
    public String login(String username, String password) throws LoginException{
        System.out.println(username + password);
        if(userStorage.containsKey(username)){
            String passwordMatch = userStorage.get(username);
            if(password.equals(passwordMatch)){
                String authToken = UUID.randomUUID().toString();
                autherizationStorage.put(authToken, username);
                return authToken;
            }
        }
        
        throw new LoginException("Login has failed");
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
        }
        throw new GeneralSecurityException();
    }
    
    public static synchronized Authenticator getInstance(){
        if(authenticator == null){
            authenticator = new Authenticator();
        }
        return authenticator;
    }
}
