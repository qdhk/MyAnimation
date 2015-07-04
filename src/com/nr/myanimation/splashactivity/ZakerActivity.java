/**
 * 
 */
package com.nr.myanimation.splashactivity;

import com.nr.myanimation.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		setContentView(R.layout.activity_splash_zaker);
		btnBelow = (Button) this.findViewById(R.id.btn_Below);
		btnAbove = (Button) this.findViewById(R.id.btn_above);
		tvHint = (TextView) this.findViewById(R.id.tv_hint);

		Animation ani = new AlphaAnimation(0f, 1f);
		ani.setDuration(1500);
		ani.setRepeatMode(Animation.REVERSE);
		ani.setRepeatCount(Animation.INFINITE);
		tvHint.startAnimation(ani);
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
			Toast.makeText(ZakerActivity.this, "��������һ�㰴ť", 1000).show();
			break;
		case R.id.btn_above:
			Toast.makeText(ZakerActivity.this, "��������һ�㰴ť", 1000).show();
			break;

		default:
			break;
		}
	}
}
