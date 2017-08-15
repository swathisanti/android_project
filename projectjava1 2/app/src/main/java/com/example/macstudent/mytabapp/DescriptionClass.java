package com.example.macstudent.mytabapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.Realm;

public class DescriptionClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_class);

        Button cartbutton=(Button)findViewById(R.id.cartbutton);


        final ImageView productImage=(ImageView)findViewById(R.id.proImage);
        // final int imageId=R.drawable.user;
        productImage.setImageResource(Integer.parseInt(getIntent().getStringExtra("productImageId")));

        final TextView productName=(TextView)findViewById(R.id.proName);
        productName.setText("Product Name: "+getIntent().getStringExtra("productName"));

        final TextView productPrice=(TextView)findViewById(R.id.proPrice);
        productPrice.setText("Product Price: "+getIntent().getStringExtra("productPrice"));


        final int id=Integer.parseInt(getIntent().getStringExtra("productImageId"));



        cartbutton.setOnClickListener(new View.OnClickListener() {








            @Override
            public void onClick(View view) {

                CartClass cartObj=new CartClass();
                cartObj.pName = productName.getText().toString();
                cartObj.price = productPrice.getText().toString();
                cartObj.image= id;

                Realm.init(getApplicationContext());
                Realm realmObj=Realm.getDefaultInstance();
                realmObj.beginTransaction();
                realmObj.copyToRealm(cartObj);
                realmObj.commitTransaction();


                AlertDialog alertDialog=new AlertDialog.Builder(DescriptionClass.this).create();

                alertDialog.setTitle("Message");

                alertDialog.setMessage("Sucessfully added to cart");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                alertDialog.show();
            }

        });
       }
     }

