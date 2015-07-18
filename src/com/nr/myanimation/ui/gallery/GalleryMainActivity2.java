/**
 * 
 */
package com.nr.myanimation.ui.gallery;

import com.nr.myanimation.R;
import com.nr.myanimation.adapter.GalleryImageAdapter;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * @author Administrator
 * 
 */
public class GalleryMainActivity2 extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 透明状态栏
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			// 透明导航栏
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_imitate_gallery2);
		Integer[] images = { R.drawable.img0001, R.drawable.img0030,
				R.drawable.img0100, R.drawable.img0130, R.drawable.img0200,
				R.drawable.img0230, R.drawable.img0330, R.drawable.img0354 };
		GalleryImageAdapter adapter = new GalleryImageAdapter(this, images);
		adapter.createReflectedImages();// 创建倒影效果

		GalleryFlow galleryFlow = (GalleryFlow) this
				.findViewById(R.id.Gallery01);
		galleryFlow.setFadingEdgeLength(0);
		galleryFlow.setSpacing(-100); // 图片之间的间距
		galleryFlow.setAdapter(adapter);

		galleryFlow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(GalleryMainActivity2.this,
						String.valueOf(position), Toast.LENGTH_SHORT).show();
			}

		});
		galleryFlow.setSelection(4);
	}
}
