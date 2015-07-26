/**
 * 
 */
package com.nr.myanimation.ui.custom.overScrollview;

import com.nr.myanimation.R;
import com.nr.myanimation.ui.custom.overScrollview.OverScrollView.OverScrollListener;
import com.nr.myanimation.ui.custom.overScrollview.OverScrollView.OverScrollTinyListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Administrator
 * 
 */
public class OverScrollActivity extends Activity implements OverScrollListener,
		OverScrollTinyListener {
	/**
	 * 初始化填充值，控制图片被隐藏的边缘值
	 */
	private static final int PADDING = -100;

	private ImageView mHeaderImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview);
		mHeaderImage = (ImageView) findViewById(R.id.image);

		OverScrollView scrollView = (OverScrollView) findViewById(R.id.layout);

		scrollView.setOverScrollListener(this);
		scrollView.setOverScrollTinyListener(this);

		// 隐藏图片的初始边界
		// 保证下拉能出现放大图片的效果
		scrollLoosen();
	}

	@Override
	public void scrollDistance(int tinyDistance, int totalDistance) {
		// TODO Auto-generated method stub
		if (totalDistance > 0 || tinyDistance == 0
				|| mHeaderImage.getPaddingBottom() == 0) {
			return;
		}
		int padding = PADDING - totalDistance / 2;
		if (padding > 0) {
			padding = 0;
		}
		mHeaderImage.setPadding(padding, 0, padding, padding);
	}

	@Override
	public void scrollLoosen() {
		// TODO Auto-generated method stub
		int padding = PADDING;
		mHeaderImage.setPadding(padding, 0, padding, padding);

		// 滑动处理松开时回调
	}

	@Override
	public void headerScroll() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "开始刷新", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void footerScroll() {
		// TODO Auto-generated method stub

	}

}
