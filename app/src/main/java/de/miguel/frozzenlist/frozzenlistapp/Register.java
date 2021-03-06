package de.miguel.frozzenlist.frozzenlistapp;


/**
 * ==========================================================================================
 *
 * @author Miguel Gutierrez, Marco Ulrich =Debugger <3 project FrozzenList
 * @version 1.0Beta
 * @param: register User: name,email,passwort(and to controlPasswort to ckeck passwortinput)
 * UserManager to save user data,
 * @link MainActivity(loginscreen)= intent
 * ==========================================================================================
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        regristryFinish = (Button) findViewById(R.id.btnRegistry);
        cancelation = (Button) findViewById(R.id.btnCanellation);

        inputName = (EditText) findViewById(R.id.bntInputName);
        inputEmail = (EditText) findViewById(R.id.bntInputEmail);
        setPasswort = (EditText) findViewById(R.id.bntsetPasswort);
        setControlPasswort = (EditText) findViewById(R.id.bntControlPasswort);

        userManager = new UserManager(this);
        regristryFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register.this.onFinishClick();
            }
        });
        cancelation.setOnClickListener(view -> cancelationClick());


    }

    private void cancelationClick() {
        Intent intent = new Intent(Register.this, LoginActivityMain.class);
        startActivity(intent);
    }

    void onFinishClick() {

        String newUser = inputName.getText().toString();
        String newEmail = inputEmail.getText().toString();
        String newPasswort = setPasswort.getText().toString();
        String newPasswortCommit = setControlPasswort.getText().toString();

        if (!newUser.isEmpty() && !newEmail.isEmpty() && !newPasswort.isEmpty() && !newPasswortCommit.isEmpty()) {

                    if (newEmail.contains("@") && newEmail.contains(".")) {
                        Log.d("Register", "it is a email");
                        if (newPasswort.length() > 7) {
                            Log.d("Register", "passwort length over 8 chars");
                            if (newPasswort.equals(newPasswortCommit)) {
                                Log.d("Register", "password confilm");
                                user = new User(newUser, newEmail, newPasswort);
                                userManager.addUser(user);
                                Log.d("Register", "User add");
                                Toast toast= Toast.makeText(this,"Sie haben sich erfolgreich regristriert", Toast.LENGTH_SHORT);
                                toast.show();
                                Intent loginScreen = new Intent(Register.this, LoginActivityMain.class);
                                startActivity(loginScreen);

                            } else {
                                setControlPasswort.setError("Passwörter stimmen nicht überein");
                            }
                        } else {
                            setPasswort.setError("Passwort muss mindestens 8 Zeichen lang sein");

                        }
                    } else {
                        inputEmail.setError("Die Emailadresse muss ein @ und einen Punkt enthalten");
                    }

                }
             else {
            if (newUser.isEmpty()) {
                inputName.setError("Sie müssen eine Nutzereingabe tätigen");
            }
            if (newEmail.isEmpty()) {
                inputEmail.setError("Sie müssen eine Email eingeben");
            }
            if (newPasswort.isEmpty()) {
                setPasswort.setError("Sie müssen ein Passwort eingeben");
            }
            if (newPasswortCommit.isEmpty()) {
                setControlPasswort.setError("Bitte wiederholen Sie ihre Passworteingabe");
            }
        }

    }

}