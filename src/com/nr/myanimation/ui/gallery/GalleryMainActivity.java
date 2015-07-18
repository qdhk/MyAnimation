package com.nr.myanimation.ui.gallery;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.nr.myanimation.R;
import com.nr.myanimation.adapter.GalleryAdapter;

/**
 * 3D图片浏览效果的主页面
 * 
 * @author Administrator
 * 
 */
public class GalleryMainActivity extends Activity {

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
		setContentView(R.layout.activity_imitate_gallery);
		initView();
	}

	public void initView() {
		CustomGallery mCustomGallery = (CustomGallery) findViewById(R.id.custom_gallery);

		int[] imageResIDs = getImageResIDs();

		GalleryAdapter mAdapter = new GalleryAdapter(this, imageResIDs);
		mCustomGallery.setAdapter(mAdapter);

	}

	private int[] getImageResIDs() {
		return new int[] { R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1, R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3, R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5, R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7, R.drawable.gallery_pic_8 };
	}
}
