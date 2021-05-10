package com.hllbr.coinbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] coins ={"BitCoin","Bat","Ripple","Chiliz"};
    private int[] ımage = {R.drawable.bircoin,R.drawable.batt,R.drawable.ripple,R.drawable.chiliz};

    private CoinAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("INFORMATION LIST OF COINS");
        listView = findViewById(R.id.listView);
        ArrayList<String> company_name = new ArrayList<>();
        company_name.add("Avustralyalı iş adamı Craig Wright");
        company_name.add("Brendan Eich");
        company_name.add("Jed McCaleb");
        company_name.add("Alexandre Dreyfus");

        ArrayList<String> date = new ArrayList<>();
        date.add("2009");
        date.add("2015");
        date.add("2012");
        date.add("2018");

        Bitmap bitcoin = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bitcoin1);
        Bitmap bat = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bat1);
        Bitmap ripple = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ripple1);
        Bitmap chiliz = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.chiliz1);

        ArrayList<Bitmap> coinsImages = new ArrayList<>();
        coinsImages.add(bitcoin);
        coinsImages.add(bat);
        coinsImages.add(ripple);
        coinsImages.add(chiliz);

        adapter = new CoinAdapter(coins,ımage,this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,detailActivity.class);
                intent.putExtra("ceo",company_name.get(position));
                intent.putExtra("date",date.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChoosenImage(coinsImages.get(position));
                startActivity(intent);
            }
        });




    }

    }
