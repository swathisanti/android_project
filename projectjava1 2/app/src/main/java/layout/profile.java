package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.macstudent.mytabapp.R;


public class profile extends Fragment {

    public  String name;
    public  String email;

    TextView userName;
    TextView userEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View viewForLayout = inflater.inflate(R.layout.fragment_profile, container, false);


        userName=(TextView)viewForLayout.findViewById(R.id.userName);
        userEmail=(TextView)viewForLayout.findViewById(R.id.userEmail);




        userName.setText("User Name: "+name);
        userEmail.setText("User Email: "+email);


        return  viewForLayout;


    }
}
