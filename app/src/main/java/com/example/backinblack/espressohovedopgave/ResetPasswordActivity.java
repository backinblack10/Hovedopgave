package com.example.backinblack.espressohovedopgave;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText inputEmail;
    public Button btnReset, btnBack;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        inputEmail = (EditText) findViewById(R.id.emailglemtpassword);
        btnReset = (Button) findViewById(R.id.buttonrestpassword);
        btnBack = (Button) findViewById(R.id.backbutton);

        auth = FirebaseAuth.getInstance();
    }

    public void Restpasswordbutton(View view) {
        String email = inputEmail.getText().toString().trim();
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPasswordActivity.this, R.string.succestilsendtemail, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetPasswordActivity.this, R.string.errorrrtilsendtemail, Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }

    public void backbutton(View view)
    {
       finish();
    }


}