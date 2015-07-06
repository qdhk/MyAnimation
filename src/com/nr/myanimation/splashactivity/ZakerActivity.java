/**
 * 
 */
package com.nr.myanimation.splashactivity;

import com.nr.myanimation.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Administrator
 * 
 */
public class ZakerActivity extends Activity implements OnClickListener {
	private Button btnBelow, btnAbove;
	private TextView tvHint;
	private int lastDownY = 0;

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
		setContentView(R.layout.activity_splash_zaker);
		btnBelow = (Button) this.findViewById(R.id.btn_Below);
		btnAbove = (Button) this.findViewById(R.id.btn_above);
		tvHint = (TextView) this.findViewById(R.id.tv_hint);

		Animation ani = new AlphaAnimation(0f, 1f);
		ani.setDuration(1500);
		ani.setRepeatMode(Animation.REVERSE);
		ani.setRepeatCount(Animation.INFINITE);
		tvHint.startAnimation(ani);
		btnAbove.startAnimation(ani);
		btnBelow.setOnClickListener(this);
		btnAbove.setOnClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_Below:
			Toast.makeText(ZakerActivity.this, "这是下面一层按钮", 1000).show();
			break;
		case R.id.btn_above:
			Toast.makeText(ZakerActivity.this, "这是上面一层按钮", 1000).show();
			break;

		default:
			break;
		}
	}
}
