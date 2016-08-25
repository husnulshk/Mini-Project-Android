package com.unpam.uts_sitihusnulkhotimah_06tplei;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.login:
			EditText userNameEditText = (EditText) findViewById(R.id.username);
			EditText passwordEditText = (EditText) findViewById(R.id.password);
			
			String userName = userNameEditText.getText().toString();
			String password = passwordEditText.getText().toString();
			
			if (userName.equals("") || password.equals("")){
				Toast.makeText(this, "User name dan password harus diisi", Toast.LENGTH_LONG).show();				
			} else {
				if (userName.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("ADMIN")){
					CheckBox simpanCheckBox = (CheckBox) findViewById(R.id.simpan);
					if (!simpanCheckBox.isChecked()){
						userNameEditText.setText("");
						passwordEditText.setText("");
					}
					
					Intent loginSuccesIntent = new Intent(this,TabView.class);
					
					loginSuccesIntent.putExtra("username", userName);
					
					startActivity(loginSuccesIntent);
				} else {
					Toast.makeText(this, "User name atau password salah", Toast.LENGTH_LONG).show();
				}
			}
			break;
		case R.id.cancel:
			System.exit(0);
		}
	}
}
