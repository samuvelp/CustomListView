package com.example.user.customlistview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] checkInsarr = new String[]{"12","1","2","3","4","5","6","7","8","9","10","11"};
        String[] checkOutarr = new String[]{"12","1","3","4","5","6","7","2","3","4","10","11"};
        ArrayList<String> checkInarrList= new ArrayList<>();
        ArrayList<String> checkOutarrList = new ArrayList<>();
        for(int i=0;i<checkInsarr.length;i++){
            checkInarrList.add(checkInsarr[i]);
            checkOutarrList.add(checkOutarr[i]);
        }
        checkOutarrList.remove(10);
        checkOutarrList.add(10,null);
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        for(int i =0;i<checkInarrList.size();i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("checkInmap",checkInarrList.get(i));
            map.put("checkOutmap",checkOutarrList.get(i));
            list.add(map);
        }
        /*String[] from ={"checkInmap","checkOutmap"};
        int[] to = {R.id.UI_TV_checkIn,R.id.UI_TV_checkOut};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.singlerow,from,to);*/

        customAdapter = new CustomAdapter(getApplicationContext(),checkInarrList,checkOutarrList);
        ListView LV_checkIn = (ListView) findViewById(R.id.UI_LV_atendance);
        LV_checkIn.setAdapter(customAdapter);

    }
}
