/**
 * 
 */
package com.nr.myanimation;

/**
 * @author Administrator
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.nr.myanimation.adapter.AnimationAdapter;
import com.nr.myanimation.base.ContantValue;
import com.nr.myanimation.base.ExitApplication;
import com.nr.myanimation.customactivity.JellyPagerActivity;
import com.nr.myanimation.customactivity.OutTicketActivity;
import com.nr.myanimation.listviewactivity.AppearanceExamplesActivity;
import com.nr.myanimation.listviewactivity.ExpandableListDemo;
import com.nr.myanimation.listviewactivity.ExpandableListItemActivity;
import com.nr.myanimation.listviewactivity.GoogleCardsActivity;
import com.nr.myanimation.listviewactivity.sortlistview.SortListViewMainActivity;
import com.nr.myanimation.splashactivity.LensFocusActivity;
import com.nr.myanimation.splashactivity.ZakerActivity;
import com.nr.myanimation.ui.gallery.GalleryMainActivity;
import com.nr.myanimation.ui.gallery.GalleryMainActivity2;
import com.nr.myanimation.ui.gallery.GalleryMainActivity3;

/**
 * Splash主页面 继承BaseActivity获取ActionBar
 * 
 * @author duguang 博客地址:http://blog.csdn.net/duguang77
 */
public class SplashMainActivity extends Activity implements OnItemClickListener {

	private long currentBackPressedTime = 0;
	private static final int BACK_PRESSED_INTERVAL = 2000;
	private AnimationAdapter adapter;
	private ListView listView_anim_complex;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim_complex);
		listView_anim_complex = (ListView) findViewById(R.id.listView_anim_complex);
		adapter = new AnimationAdapter(this, ContantValue.splashName1);
		listView_anim_complex.setAdapter(adapter);
		listView_anim_complex.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			startIntent(ZakerActivity.class);
			break;
		case 1:
			startIntent(LensFocusActivity.class);
			break;
		case 2:
			startIntent(GoogleCardsActivity.class);
			break;
		case 3:
			startIntent(OutTicketActivity.class);
			break;
		case 4:
			startIntent(AppearanceExamplesActivity.class);
			break;
		case 5:
			startIntent(ExpandableListItemActivity.class);
			break;
		case 6:
			startIntent(ExpandableListDemo.class);
			break;
		case 7:
			startIntent(SortListViewMainActivity.class);
			break;
		case 8:
			startIntent(GalleryMainActivity.class);
			break;
		case 9:
			startIntent(GalleryMainActivity2.class);
			break;
		case 10:
			startIntent(GalleryMainActivity3.class);
			break;
		case 11:
			startIntent(JellyPagerActivity.class);
			break;
		default:
			break;
		}

	}

	/**
	 * 切换Activity
	 * 
	 * @param class1
	 */
	public void startIntent(Class class1) {
		Intent intent = new Intent(SplashMainActivity.this, class1);
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
			currentBackPressedTime = System.currentTimeMillis();
			Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
		} else {
			ExitApplication.getInstance().exit(this);
		}
	}
}
