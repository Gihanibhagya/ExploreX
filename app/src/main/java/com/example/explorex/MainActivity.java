package com.example.explorex;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.btnLogin);
        button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.prclr)));


        Button button1 = findViewById(R.id.btnSignUp);
        button1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.prclr)));

        Button signUpTextView = findViewById(R.id.btnLogin);
        signUpTextView.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, loginActivity.class));
        });

        Button signUpTextView2 = findViewById(R.id.btnSignUp);
        signUpTextView2.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, siginActivity.class));
        });
    }
}