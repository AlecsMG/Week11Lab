package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(user.getEmail(), "Notes App Login", path + "/emailtemplates/login.html", tags);
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean forgotPassword(String path, String email) {
        boolean valid = false;
        
        UserDB userDB = new UserDB();
        try {
            User user = userDB.get(email);
            if (email.equals(user.getEmail())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "{0} requested their passwors.", email);
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("email", user.getEmail());
                tags.put("password", user.getPassword());
                
                GmailService.sendMail(user.getEmail(), "Forgot Password", path + "/emailtemplates/forgotpassword.html", tags);
                valid = true;
            }
        } catch (Exception e) {
        }
        
        
        return valid;
    }
}
