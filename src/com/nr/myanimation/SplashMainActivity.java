/**
 * 
 */
package com.nr.myanimation;

/**
 * @author Administrator
 *
 */

import com.nr.myanimation.adapter.AnimationAdapter;
import com.nr.myanimation.base.ContantValue;
import com.nr.myanimation.listviewactivity.GoogleCardsActivity;
import com.nr.myanimation.splashactivity.LensFocusActivity;
import com.nr.myanimation.splashactivity.ZakerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Splash主页面 继承BaseActivity获取ActionBar
 * 
 * @author duguang 博客地址:http://blog.csdn.net/duguang77
 */
public class SplashMainActivity extends Activity implements OnItemClickListener {

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
		adapter = new AnimationAdapter(this, ContantValue.splashName);
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
			// break;
			// case 3:
			// startIntent(Rotate3DActivity.class);
			// break;
			// case 4:
			// startIntent(ViewPagerActivity.class);
			// break;
			// case 5:
			// startIntent(Activity1.class);
			// break;
			// case 6:
			// startIntent(FadeSplashScreenActivity.class);
			// break;
			// case 7:
			// startIntent(Fade2MainActivity.class);
			// break;

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

}
