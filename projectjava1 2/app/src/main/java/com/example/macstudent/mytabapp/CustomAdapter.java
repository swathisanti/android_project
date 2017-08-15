package com.example.macstudent.mytabapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmResults;


/**
 * Created by macstudent on 2017-04-24.
 */

public class CustomAdapter extends ArrayAdapter<ItemClass>{

    private RealmResults<ItemClass> dataSet;
    Context mContext;


    public CustomAdapter(RealmResults<ItemClass> data, Context context) {

        super(context, R.layout.row_item, data);

        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) { // for the first time, inflate the view
            LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
        }

        TextView productName = (TextView)convertView.findViewById(R.id.ProductNameID);
        TextView productPrice = (TextView)convertView.findViewById(R.id.ProductPriceID);
        ImageView productImg = (ImageView)convertView.findViewById(R.id.imageView);

        ItemClass temp = dataSet.get(position);


        productName.setText(temp.pName);
        productPrice.setText(String.valueOf(temp.price));
        productImg.setImageResource(temp.image);

        return convertView;
    }





}


