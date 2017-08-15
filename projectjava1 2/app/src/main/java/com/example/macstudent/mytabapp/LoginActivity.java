package com.example.macstudent.mytabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.macstudent.mytabapp.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    Button Register;
    EditText UserName;
    EditText Password;
    TextView errorMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login =(Button) findViewById(R.id.loginbutton) ;
        UserName = (EditText) findViewById(R.id.edittextusername);
        Password = (EditText) findViewById(R.id.edittextpassword);
        errorMsg = (TextView) findViewById(R.id.errorMsg);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
       final RealmResults<objectclass> obj=realm.where(objectclass.class).findAll();

        Login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String userName;
                String passWord;

                boolean check=false;
                for(int i=0;i<obj.size();i++){

                    userName=obj.get(i).username;
                    passWord=obj.get(i).password;

                    if(UserName.getText().toString().equalsIgnoreCase(userName)&&Password.getText().toString().equalsIgnoreCase(passWord)){


                        check=true;


                    }
                }

                if(check){

                    Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();

                    Intent newScreen = new Intent(getApplication(),welcome.class);

                    startActivity(newScreen);

                }
                else{


                    Toast.makeText(getApplicationContext(), "Invalid userName or password", Toast.LENGTH_SHORT).show();



                }



                }
             });

    }

}
