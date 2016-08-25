package com.unpam.uts_sitihusnulkhotimah_06tplei;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Dipilih extends Activity implements OnItemClickListener{
	List<String> items = new ArrayList<String>();
	ListView mataKuliahListView;
	String mataKuliah[] = {"Pemrograman I","Pemrograman II","Mobile Programming",
			"Basis Data I","Basis Data II","Struktur Data I","Struktur Data II",
			"Algoritma Pemrograman I","Algoritma Pemrograman I","Agama",
			"Bahasa Inggris I","Bahasa Inggris II","Bahasa Indonesia"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list_view);
        
        mataKuliahListView = (ListView) findViewById(R.id.listView1);
        mataKuliahListView.setOnItemClickListener(this);
        
        for (int i=0; i<mataKuliah.length; i++){
        	items.add(mataKuliah[i]);
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,items);
        mataKuliahListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_list_view, menu);
        return true;
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, items.get(arg2), Toast.LENGTH_SHORT).show();
		
		Intent dipilihIntent = new Intent(this,Dipilih.class);
		dipilihIntent.putExtra("matakuliah", items.get(arg2));
		startActivity(dipilihIntent);
	}
}
