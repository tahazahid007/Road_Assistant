package com.wemo.roadassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class LoginRegistrationActivity extends AppCompatActivity {

    private final String PREFS_NAME = "Prefs_ROAD_ASSIST";
    private static String TAG = "Main Activity";
    private SharedPreferences sharedPreferences;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private Context context;
    private FirebaseAuth mAuth;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        if(!getSharedPreference(context, "login")){
            initView();
        }
        else {
            startActivity(new Intent(LoginRegistrationActivity.this, FindServices.class));
        }


    }

    private void initView() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        register = findViewById(R.id.register);
        clickListener();
    }

    private void clickListener() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setText("Register");
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnLogin.getText().toString().equals("Register")) {
                    registration();
                } else if (btnLogin.getText().toString().equals("Login")) {
                    login();
                }
            }
        });
    }

    private void login() {
        final String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("Please Enter Your Email");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            etPassword.setError("Please Enter Your Password");
            etPassword.requestFocus();
        } else if (!email.isEmpty() && !password.isEmpty()) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                showDialog(context);
                                saveSharedPreference(context, "login", true);
                                Intent intent = new Intent(LoginRegistrationActivity.this, FindServices.class);
                                startActivity(intent);
                            } else {
                                {
                                    try {
                                        throw task.getException();
                                    }
                                    // if user enters wrong email.
                                    catch (FirebaseAuthWeakPasswordException weakPassword) {
                                        Log.d(TAG, "onComplete: weak_password");
                                        Toast.makeText(context, "Weak Password", Toast.LENGTH_SHORT).show();

                                        // TODO: take your actions!
                                    }
                                    // if user enters wrong password.
                                    catch (FirebaseAuthInvalidCredentialsException malformedEmail) {
                                        Log.d(TAG, "onComplete: malformed_email");
                                        Toast.makeText(context, "Email is not Valid", Toast.LENGTH_SHORT).show();

                                        // TODO: Take your action
                                    } catch (FirebaseAuthUserCollisionException existEmail) {
                                        Log.d(TAG, "onComplete: exist_email");
                                        Toast.makeText(context, "Email is already exist", Toast.LENGTH_SHORT).show();

                                        // TODO: Take your action
                                    } catch (Exception e) {
                                        Toast.makeText(context, email +"  is not exist", Toast.LENGTH_SHORT).show();
                                        Log.d(TAG, "onComplete: " + e.getMessage());
                                    }
                                }
                            }
                        }
                    });
        } else {
            Toast.makeText(context, "Houston! We have a Problem", Toast.LENGTH_SHORT).show();
        }
    }

    private void registration() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        final String emailValue = email;

        if (email.isEmpty()) {
            etEmail.setError("Please Enter Your Email");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            etPassword.setError("Please Enter Your Password");
            etPassword.requestFocus();
        } else if (!email.isEmpty() && !password.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginRegistrationActivity.this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show();

                                        btnLogin.setText("Login");
                                    } else {
                                        {
                                            try {
                                                throw task.getException();
                                            }
                                            // if user enters wrong email.
                                            catch (FirebaseAuthWeakPasswordException weakPassword) {
                                                Log.d(TAG, "onComplete: weak_password");
                                                Toast.makeText(context, "Weak Password", Toast.LENGTH_SHORT).show();

                                                // TODO: take your actions!
                                            }
                                            // if user enters wrong password.
                                            catch (FirebaseAuthInvalidCredentialsException malformedEmail) {
                                                Log.d(TAG, "onComplete: malformed_email");
                                                Toast.makeText(context, "Email is not Valid", Toast.LENGTH_SHORT).show();

                                                // TODO: Take your action
                                            } catch (FirebaseAuthUserCollisionException existEmail) {
                                                Log.d(TAG, "onComplete: exist_email");
                                                Toast.makeText(context, "Email is already exist", Toast.LENGTH_SHORT).show();

                                                // TODO: Take your action
                                            } catch (Exception e) {
                                                Toast.makeText(context, emailValue +"  is not exist", Toast.LENGTH_SHORT).show();
                                                Log.d(TAG, "onComplete: " + e.getMessage());
                                            }
                                        }
                                    }
                                }
                            });
        } else {
            Toast.makeText(context, "Houston! We have a Problem", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveSharedPreference(Context context, String key, boolean value){
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private Boolean getSharedPreference(Context context, String key){
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}