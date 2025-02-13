package com.example.explorex;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox button3 = findViewById(R.id.checkBox2);
        button3.setButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.prclr)));

        Button button = findViewById(R.id.butt);
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.prclr)));

        EditText emailEditText = findViewById(R.id.editTextText);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword2);

        Button signInButton = findViewById(R.id.butt);
        signInButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.equals("user@example.com") && password.equals("gihani")) {
                // Navigate to HomeActivity
                startActivity(new Intent(loginActivity.this, HomeActivity.class));
            } else {
                // Show error message
                Toast.makeText(loginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
        TextView signUpTextView2 = findViewById(R.id.textView7);
        signUpTextView2.setOnClickListener(view -> {
            startActivity(new Intent(loginActivity.this, siginActivity.class));
        });
    }
}
