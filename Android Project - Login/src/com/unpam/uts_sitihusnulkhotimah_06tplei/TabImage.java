package com.unpam.uts_sitihusnulkhotimah_06tplei;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class TabImage extends Activity implements OnClickListener{
	static final int REQ_CAMERA = 0;
	static final int REQ_GALLERY = 1;
	ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_image);
        
        imageView = (ImageView) findViewById(R.id.imageView1);
        findViewById(R.id.ambilgambar).setOnClickListener(this);
        findViewById(R.id.tampilkangambar).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_image, menu);
        return true;
    }

    public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.ambilgambar:
			Intent cameraIntent = new Intent(
					android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, REQ_CAMERA);
			break;
		case R.id.tampilkangambar:
			Intent galeriIntent = new Intent(Intent.ACTION_PICK);
			galeriIntent.setType("image/*");
			startActivityForResult(galeriIntent, REQ_GALLERY);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent data){
		switch (requestCode){
		case REQ_CAMERA:
			if (resultCode == RESULT_OK){
				Bitmap bmp = (Bitmap) data.getExtras().get("data");
				imageView.setImageBitmap(bmp);
				
				android.provider.MediaStore.Images.Media.insertImage(
						getContentResolver(), bmp, null, null);
			} else {
				Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
			}
		case REQ_GALLERY:
			if (resultCode == RESULT_OK){
				Uri galeriUri = data.getData();
				imageView.setImageURI(galeriUri);
			}
		}
	}
}
