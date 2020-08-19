package de.miguel.frozzenlist.frozzenlistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivityMain extends Activity {

    Button btnRegister;
    Button btnSignIn;
    EditText inputEmail;
    EditText inputPasswort;

    ArrayList<Serializable> userArrayList= new ArrayList<java.io.Serializable>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        inputEmail= (EditText)findViewById(R.id.username);
        inputPasswort= (EditText)findViewById(R.id.password);

        //register condition
        btnRegister= (Button)findViewById(R.id.btnRegisterMain);
        btnRegister.setOnClickListener(view -> registerClick());

        // sign in condition
        btnSignIn= (Button)findViewById(R.id.btnLogin);
        btnSignIn.setOnClickListener(view -> signInClick());
    }
    void signInClick(){
        Log.d("MainActivity","test");
        String userEmail = inputEmail.getText().toString();
        String passwort = inputPasswort.getText().toString();
        if(userEmail.isEmpty()) {
            inputEmail.setError("Bitte Email eingeben");
            inputEmail.requestFocus();
        }
        else if(passwort.isEmpty()){
            inputPasswort.setError("Bitte Passwort eingeben");
            inputPasswort.requestFocus();
        }

        if(!userEmail.isEmpty()&&!passwort.isEmpty()) {
            UserManager userManager= new UserManager(this);
            User user= new User(passwort,userEmail);
            for(int i = 0; i< userManager.getUserList().size(); i++){

                User compareUser= userManager.getUserList().get(i);
                if(compareUser.getEmail().equals(user.getEmail())&&compareUser.getPasswort().
                        equals(user.getPasswort())){
                    Intent intent= new Intent(LoginActivityMain.this, FreezerManagment.class);
                    Log.d("LoginActivityMain","jssj");
                    intent.putExtra("position", i);
                    startActivity(intent);
                    Log.d("LoginActivityMain","jjj");
                }
                else{
                    Log.d("LoginActivityMain","Stimmt mit keinem User überein");
                }
            }
        }
    }
    //register button
    void registerClick(){
        Intent intent = new Intent(LoginActivityMain.this,Register.class);
        startActivity(intent);

    }
}