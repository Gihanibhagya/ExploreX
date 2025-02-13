package com.example.explorex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView signUpTextView2 = findViewById(R.id.home_icon);
        signUpTextView2.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, HomeActivity.class));
        });

        ImageView signUpTextView3 = findViewById(R.id.loca);
        signUpTextView3.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, Addplace.class));
        });

        ImageView signUpTextView4 = findViewById(R.id.chat);
        signUpTextView4.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, chatActivity.class));
        });

        ImageView signUpTextView5 = findViewById(R.id.place);
        signUpTextView5.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, tripsActivity.class));
        });
        ImageView signUpTextView6 = findViewById(R.id.lo);
        signUpTextView6.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, Addplace.class));
        });

        int[] visitplaces = {R.id.img1, R.id.img2, R.id.img3, R.id.img4,R.id.img5,R.id.img6,R.id.img7,R.id.img8};
        for (int id :visitplaces ) {
            ImageView donation = findViewById(id);
            if (donation != null) {
                donation.setOnClickListener(view -> {
                    Intent intent = new Intent(HomeActivity.this, Addplace.class);
                    startActivity(intent);
                });
            }
        }

        int[] visitplaces2 = {R.id.card_image2, R.id.card_image21, R.id.card_image214, R.id.card_image2164};
        for (int id :visitplaces2 ) {
            ImageView donation = findViewById(id);
            if (donation != null) {
                donation.setOnClickListener(view -> {
                    Intent intent = new Intent(HomeActivity.this, tripsActivity.class);
                    startActivity(intent);
                });
            }
        }
    }
}