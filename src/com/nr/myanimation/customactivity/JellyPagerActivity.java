/**
 * 
 */
package com.nr.myanimation.customactivity;

/**
 * @author Administrator
 *
 */

import com.nr.myanimation.adapter.JellyFragPagerAdapter;
import com.nr.myanimation.widget.JellyViewPager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Toast;
import com.nr.myanimation.R;

public class JellyPagerActivity extends FragmentActivity {
	JellyViewPager pager;
	int currentItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jellyview);
		pager = (JellyViewPager) findViewById(R.id.myViewPager1);
		// pager.setAdapter(new TestPagerAdapter(this));
		pager.setAdapter(new JellyFragPagerAdapter(getSupportFragmentManager()));
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int state) {
				switch (state) {
				case 1: // ���ڻ���
					break;
				case 2: // ��������
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageSelected(int arg0) {
			}

		});
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.preBtn:
			pager.showPre();
			break;
		case R.id.nextBtn:
			pager.showNext();
			break;
		}
	}

}
