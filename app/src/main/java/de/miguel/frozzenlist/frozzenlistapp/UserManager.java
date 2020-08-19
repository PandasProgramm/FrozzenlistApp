package de.miguel.frozzenlist.frozzenlistapp;


import android.content.Context;

import com.orhanobut.hawk.Hawk;

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

    public ArrayList<User> userList=new ArrayList<>();;

    //Instance
    public UserManager(Context context){
        Hawk.init(context).build();
        loadList();

    }

    public void saveList(){


          Hawk.put("userList", userList);

    }
    public void loadList(){

      userList= Hawk.get("userList",userList);

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
