package com.example.erecycler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class signupactivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    EditText edittextemail;
    EditText edittextpassword;
    EditText edittextMobileno;
    ImageView googleimage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }

        edittextemail = (EditText)findViewById(R.id.editTextTextEmailAddress);
        edittextpassword = (EditText) findViewById(R.id.editTextTextPassword);
        edittextMobileno = (EditText) findViewById(R.id.editTextPhone);
        googleimage = (ImageView) findViewById(R.id.googleimg);
        googleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });
    }

    private void signIn() {
        Intent signintent = gsc.getSignInIntent();
        startActivityForResult(signintent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
                Toast.makeText(this, "you signed up successfully",Toast.LENGTH_SHORT).show();

                finish();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void navigateToSecondActivity() {
        Intent intent = new Intent(signupactivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void signupButtonClicked(View v){
        String txtemail = edittextemail.getText().toString().trim();
        String txtpassword = edittextpassword.getText().toString().trim();
        String txtphone = edittextMobileno.getText().toString().trim();

        if(txtemail.isEmpty()){
            edittextemail.setError("please enter username");
            edittextemail.requestFocus();
        }
        if(txtpassword.isEmpty()|| txtpassword.length()<6){
            edittextpassword.setError("please enter password");
            edittextpassword.requestFocus();
        }
        if(txtphone.isEmpty()){
            edittextMobileno.setError("please enter mobile number");
            edittextMobileno.requestFocus();
        }
    }
}