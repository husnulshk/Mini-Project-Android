package com.unpam.uts_sitihusnulkhotimah_06tplei;
import android.app.Activity;
import android.view.Menu;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabView extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);
        
        Intent intent;
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;
        
        intent = new Intent(this,TabListView.class);
        tabSpec = getTabHost().newTabSpec("Tab1").setIndicator("Tab Liat View")
        		.setContent(intent);
        tabHost.addTab(tabSpec);        

        intent = new Intent(this,TabImage.class);
        tabSpec = getTabHost().newTabSpec("Tab2").setIndicator("Tab Image")
                		.setContent(intent);
        tabHost.addTab(tabSpec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_view, menu);
        return true;
    }
}
