package com.example.macstudent.mytabapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.RealmResults;

/**
 * Created by user on 2017-04-28.
 */

public class AdapterCart  extends ArrayAdapter {


    private RealmResults<CartClass> dataSet;
    Context contex;


    public AdapterCart(RealmResults<CartClass> data, Context context) {

        super(context, R.layout.activity_description_class, data);
        this.dataSet = data;
        this.contex=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) { // for the first time, inflate the view
            LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.cartitems, parent, false);
        }

        TextView productName = (TextView)convertView.findViewById(R.id.cNameID);
        TextView productPrice = (TextView)convertView.findViewById(R.id.cPriceID);
        ImageView productImg = (ImageView)convertView.findViewById(R.id.cartImageView);

        CartClass temp = dataSet.get(position);


        productName.setText(temp.pName);
        productPrice.setText(temp.price);
        productImg.setImageResource(temp.image);

        return convertView;
    }







}
