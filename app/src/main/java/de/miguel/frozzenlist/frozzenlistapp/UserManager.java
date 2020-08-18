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

    private ArrayList<User> userList;

    //Instance
    public UserManager(Context context){
        Hawk.init(context).build();
        loadList();

    }

    public void saveList(){

     /*   try {
            OutputStream outputStream= new FileOutputStream(new File("userList.txt"));
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Hawk.put("userList", userList);

    }
    public void loadList(){

      /*  try{
            InputStream inputStream=new FileInputStream("userList.txt");
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            userList= (ArrayList<User>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
       userList= Hawk.get("userList",new ArrayList<User>());

    }
    public void addUser(User user){
        getUserList().add(user);
        saveList();
    }
    public void removeUser(int position){
        getUserList().remove(position);
        saveList();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
