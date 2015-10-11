package com.diegocarloslima.byakugallery.sample;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.diegocarloslima.byakugallery.R;
import com.diegocarloslima.byakugallery.lib.TileBitmapDrawable;
import com.diegocarloslima.byakugallery.lib.TouchImageView;

import java.io.*;
import java.nio.channels.FileChannel;

public class ExifSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.item_gallery);

		final TouchImageView image = (TouchImageView) findViewById(R.id.gallery_view_pager_sample_item_image);
		final Drawable placeHolder = getResources().getDrawable(R.drawable.android_placeholder);

		File file=new File(getCacheDir(), "exif.jpg");
		try {
			InputStream is = getResources().openRawResource(R.raw.exif);
			FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
			byte[] buf=new byte[1024];
			int len;
			while((len=is.read(buf))>0){
				out.write(buf,0,len);
			}
			is.close();
			out.close();
		    TileBitmapDrawable.attachTileBitmapDrawable(image, file.getAbsolutePath(), placeHolder, null);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
