package de.miguel.frozzenlist.frozzenlistapp;


import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 ==============================================================
 @author Miguel Gutierrez, project FrozzenList
 @version 1.0Beta
 @param: save Userunit: Hawk to saveList,loadList and addUser
 @Link userManager
 ==============================================================
 */

public class UserManager {

    private ArrayList<User> userList=new ArrayList<>();
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    public File filename=new File("userList.txt");

    InputStream inputStream;
    ObjectInputStream objectInputStream;


    //Instance
    public UserManager(Context context){

        loadList();

    }



    public void saveList(){


        try {

            outputStream= new FileOutputStream(filename);
            objectOutputStream= new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  Hawk.put("userList", userList);

    }
    public void loadList(){

        try{
            inputStream=new FileInputStream("userList.txt");
            objectInputStream= new ObjectInputStream(inputStream);
            userList= (ArrayList<User>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     //  userList= Hawk.get("userList",new ArrayList<User>());

    }
    public void addUser(User user){
        userList.add(user);
        saveList();
    }
    public void removeUser(int position){
        userList.remove(position);
        saveList();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

}
