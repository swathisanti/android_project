package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.macstudent.mytabapp.AdapterCart;
import com.example.macstudent.mytabapp.CartClass;
import com.example.macstudent.mytabapp.R;

import io.realm.Realm;
import io.realm.RealmResults;


public class cart extends Fragment  {



    ListView cartListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Realm.init(getContext());
        Realm realmObj=Realm.getDefaultInstance();

        final RealmResults<CartClass> objects=realmObj.where(CartClass.class).findAll();

        View viewForLayout = inflater.inflate(R.layout.fragment_cart, container, false);

        AdapterCart myAdapter = new AdapterCart(objects, getContext());


        cartListView= (ListView)viewForLayout.findViewById(R.id.cartList);

        cartListView.setAdapter(myAdapter);



        return viewForLayout;
     }}
