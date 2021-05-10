package com.hllbr.coinbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CoinAdapter extends ArrayAdapter<String> {
    private String[] coins ;
    private int[] image;
    private Context context;
    private TextView coinIsmı ;
    private ImageView coinImage ;
    public CoinAdapter(String[] coins,int [] image,Context context){
        super(context,R.layout.coin_item,coins);
        this.coins = coins;
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.coin_item,null);
        if(view != null){
            coinIsmı = view.findViewById(R.id.coin_nameText);
            coinImage = view.findViewById(R.id.coin_item_imageView);

            coinIsmı.setText(coins[position]);
            coinImage.setBackgroundResource(image[position]);
        }
        return view;
    }
}
