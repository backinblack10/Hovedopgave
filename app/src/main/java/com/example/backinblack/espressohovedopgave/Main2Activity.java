package com.example.backinblack.espressohovedopgave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    private EditText inputmail, inputpassword;
    private FirebaseAuth auth;
    public Button btnsign, btnsignup, btnrestpassword;
    boolean cancel = false;
    View focusView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth = FirebaseAuth.getInstance();
         inputmail = (EditText)findViewById(R.id.Email);
        inputpassword = (EditText)findViewById(R.id.Password);
        btnsign = (Button)findViewById(R.id.signin);
        btnsignup = (Button) findViewById(R.id.buttonsignup);
        btnrestpassword = (Button) findViewById(R.id.buttonrestpassword);


    }

    public void Signup(View view )
    {

        String email = inputmail.getText().toString();
        String password = inputpassword.getText().toString();

        try {
            if (TextUtils.isEmpty(email) )
            {
                inputmail.setError("email må ikke være tom");
                focusView = inputmail;
                cancel = true;
                focusView.requestFocus();
            }
            else if(!isEmailValid(email))
            {
                inputmail.setError("email skal indholde @");
                focusView = inputmail;
                cancel = true;
                focusView.requestFocus();

            }
              if (!IsPasswordlegal(password))
            {
                inputpassword.setError("antal tegn skal være mellem 6 og 30");
                focusView = inputpassword;
                cancel = true;
                focusView.requestFocus();
            }
            else  if (TextUtils.isEmpty(password))
              {
                inputpassword.setError("passwordfeltet skal være udfyldt");
                  focusView = inputpassword;
                  cancel = true;
                  focusView.requestFocus();
              }
            auth.createUserWithEmailAndPassword(email, password ).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if (!task.isSuccessful())
                    {
                        Toast.makeText(getBaseContext(), getString(R.string.errorrregistrer) , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText( getBaseContext(), getString(R.string.succesregistrer) , Toast.LENGTH_LONG ).show();
                    }
                }
            });
        }catch (Exception e)
        {
          e.getMessage();
        }

    }


    public void Forgotpassword(View view)
    {
      Intent intent = new Intent(getBaseContext(), ResetPasswordActivity.class );
        startActivity(intent);
    }

    public void Login(View view)
    {  final String email = inputmail.getText().toString();
        final String password = inputpassword.getText().toString();
        
        try {
            if (TextUtils.isEmpty(email))
            {
                inputmail.setError("email må ikke være tom");
                focusView = inputmail;
                cancel = true;
                focusView.requestFocus();
            }
            else if (!isEmailValid(email))
            {
               inputmail.setError("email skal indholde @");
                focusView = inputmail;
                cancel = true;
                focusView.requestFocus();
            }
            if (!IsPasswordlegal(password)  )
            {
                inputpassword.setError("antal tegn skal være mellem 6 og 30");
                focusView = inputpassword;
                cancel = true;
                focusView.requestFocus();
            }
            else if (TextUtils.isEmpty(password))
            {
              inputpassword.setError("passwordfeltet skal være udfyldt");
                focusView = inputpassword;
                cancel = true;
                focusView.requestFocus();
            }

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(getBaseContext(), getString(R.string.loginfail) , Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }catch (Exception e) {
          e.getMessage();
        }
    }

    private boolean IsPasswordlegal(String string) {return string.length() >= 6 && string.length() < 30; }
    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
