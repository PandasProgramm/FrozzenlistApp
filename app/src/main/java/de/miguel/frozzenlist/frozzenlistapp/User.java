package de.miguel.frozzenlist.frozzenlistapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 =============================================================================================
 @author Miguel Gutierrez, project FrozzenList
 @version 1.0Beta
 @param: conntent UserObject: Attributs:name,passwort,email:option to change Passwort
 in a other Activity, optional:link for email
 @link MainActivity,UserManager,Registry
 =============================================================================================
 */

public class User implements Serializable {


    private String userName;
    private String passwort;
    private String email;
    ArrayList<Freezer>freezers;


    public User(String passwort,String email){
        this.passwort=passwort;
        this.email=email;
        if(freezers==null){
            freezers=new ArrayList<>();
        }

        //for login

    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort=passwort;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String inputEmail){
        this.email=inputEmail;
    }
    public void changePasswort(String input)
    {
        this.passwort= input;
    }
}
