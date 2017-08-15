package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.macstudent.mytabapp.CustomAdapter;
import com.example.macstudent.mytabapp.DescriptionClass;
import com.example.macstudent.mytabapp.ItemClass;
import com.example.macstudent.mytabapp.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class home extends Fragment {
    ListView myProductList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
     {
         Realm.init(getContext());
         Realm realmObj=Realm.getDefaultInstance();

         final RealmResults<ItemClass> item=realmObj.where(ItemClass.class).findAll();
         final View viewLayout = inflater.inflate(R.layout.fragment_home, container, false);



         CustomAdapter myAdapter = new CustomAdapter(item, getContext());



         myProductList = (ListView)viewLayout.findViewById(R.id.listview);

         myProductList.setAdapter(myAdapter);

         myProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position,
                                   long id) {
               Intent intent = new Intent(getContext(), DescriptionClass.class);


              intent.putExtra("productName",item.get(position).pName);
               intent.putExtra("productPrice",String.valueOf(item.get(position).price));
              intent.putExtra("productImageId",String.valueOf(R.drawable.sam));



               startActivity(intent);
           }
       });

return (viewLayout);
   }

}
