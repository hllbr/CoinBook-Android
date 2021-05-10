package com.hllbr.coinbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    TextView ceoText,nameText;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ceoText = findViewById(R.id.ceoNameText);
        nameText = findViewById(R.id.dateText);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String ceo = intent.getStringExtra("ceo");
        String date = intent.getStringExtra("date");
        ceoText.setText(ceo);
        nameText.setText(date);
        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChoosenImage());
    }
}