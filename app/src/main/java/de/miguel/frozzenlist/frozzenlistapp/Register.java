package de.miguel.frozzenlist.frozzenlistapp;

/**
 ==========================================================================================
 @author Miguel Gutierrez, project FrozzenList
 @version 1.0Beta
 @param: register User: name,email,passwort(and to controlPasswort to ckeck passwortinput)
 UserManager to save user data,
 @link MainActivity(loginscreen)= intent
 ==========================================================================================
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    Button regristryFinish;
    Button cancelation;
    EditText inputName;
    EditText inputEmail;
    EditText setPasswort;
    EditText setControlPasswort;
    User user;
    UserManager userManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        regristryFinish=(Button)findViewById(R.id.btnRegistry);
        cancelation=(Button)findViewById(R.id.btnCanellation);

        inputName= (EditText)findViewById(R.id.bntInputName);
        inputEmail=(EditText)findViewById(R.id.bntInputEmail);
        setPasswort=(EditText)findViewById(R.id.bntsetPasswort);
        setControlPasswort=(EditText)findViewById(R.id.bntControlPasswort);

        userManager= new UserManager(this);
        regristryFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register.this.onFinishClick();
            }
        });
        cancelation.setOnClickListener(view -> cancelationClick());


    }

    private void cancelationClick() {
        Intent intent= new Intent(Register.this,LoginActivityMain.class);
        startActivity(intent);
    }

    void onFinishClick() {

        String newUser = inputName.getText().toString();
        String newEmail = inputEmail.getText().toString();
        String newPasswort = setPasswort.getText().toString();
        String newPasswortCommit = setControlPasswort.getText().toString();

        if (newPasswort.equals(newPasswortCommit) && newEmail.length() > 0) {

            user = new User(newEmail, newPasswort);

            if (newPasswort.equals(newPasswortCommit) && newUser.length() > 0 && newEmail.length() > 0) {

                user = new User(newPasswort, newEmail);

                userManager.addUser(user);

                Intent loginScreen = new Intent(Register.this, LoginActivityMain.class);
                startActivity(loginScreen);

            }
        }
    }
}