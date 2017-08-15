package com.example.macstudent.mytabapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    Button register;
    EditText username,password,emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplication());

        Realm realmObj=Realm.getDefaultInstance();

        realmObj.beginTransaction();


        realmObj.delete(objectclass.class);
        realmObj.delete(CartClass.class);
        realmObj.commitTransaction();


        // int id =R.drawable.user;
        CartClass cartObj= new CartClass();
        cartObj.pName="DEll";
        cartObj.price="900";
        cartObj.image=R.drawable.dell;

        ItemClass obj=new ItemClass();
        obj.pName="Dell";
        obj.image=R.drawable.dell;
        obj.price = 800;

        ItemClass obj1=new ItemClass();
        obj1.pName="MacBook";
        obj1.image=R.drawable.macbookair;
        obj1.price = 1100;



        realmObj.beginTransaction();
        realmObj.copyToRealm(obj);
        realmObj.copyToRealm(obj1);

        realmObj.copyToRealm(cartObj);
        realmObj.commitTransaction();

        username = (EditText) findViewById(R.id.edittextusernamer);
        password = (EditText) findViewById(R.id.edittextpasswordr);
        emailid = (EditText)findViewById(R.id.edittextemailr);
        register =(Button) findViewById(R.id.registerbutton2);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String username1 = String.valueOf(username.getText());
                String password1 = String.valueOf(password.getText());
                String emailid1 = String.valueOf(emailid.getText());
                objectclass myhelper = new objectclass();
                Realm.init(getApplicationContext());Realm realm = Realm.getDefaultInstance();


                myhelper.username = username1;
                myhelper.password = password1;
                myhelper.emailid = emailid1;
                realm.beginTransaction();
                objectclass realmData = realm.copyToRealm(myhelper);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();


                Intent newScreen = new Intent(getApplication(),LoginActivity.class);
               startActivity(newScreen);
            }
        });
    }
    }

