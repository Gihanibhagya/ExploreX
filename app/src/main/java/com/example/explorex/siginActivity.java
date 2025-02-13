package com.example.explorex;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class siginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton, loginButton;
    private CheckBox rememberMeCheckBox;
    private TextView forgotPasswordText, alreadyHaveAccountText;
    private ImageView passwordToggle;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);


        usernameEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextText2);
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword2);
        registerButton = findViewById(R.id.button);
        loginButton = findViewById(R.id.button6);
        rememberMeCheckBox = findViewById(R.id.checkBox);
        forgotPasswordText = findViewById(R.id.textView6);
        alreadyHaveAccountText = findViewById(R.id.textView8);
        passwordToggle = findViewById(R.id.imageView2);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(siginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(siginActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform registration logic (replace with actual authentication logic)
                    Toast.makeText(siginActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(siginActivity.this, loginActivity.class);
                    startActivity(intent);
                }
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(siginActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });


        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(siginActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });


        passwordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    confirmPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    isPasswordVisible = false;
                } else {
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    confirmPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    isPasswordVisible = true;
                }
                passwordEditText.setSelection(passwordEditText.getText().length());
                confirmPasswordEditText.setSelection(confirmPasswordEditText.getText().length());
            }
        });
    }
}
