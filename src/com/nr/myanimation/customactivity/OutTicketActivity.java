/**
 * 
 */
package com.nr.myanimation.customactivity;

import com.nr.myanimation.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author Administrator
 * 
 */
public class OutTicketActivity extends Activity {
	private RelativeLayout rl_payInfo;
	private ImageView imageView;
	private Animation anim;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				startAnimation();
				break;

			default:
				break;
			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_imitate_outticket);
		rl_payInfo = (RelativeLayout) findViewById(R.id.rl_payInfo);
		imageView = (ImageView) findViewById(R.id.iv_success);
		newThread();
	}

	/**
	 * 测试用的,开启子线程
	 */
	private void newThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Message msg = new Message();
				msg.what = 1;
				handler.sendMessage(msg);

			}
		}).start();
	}

	/**
	 * 启动打印小票动画
	 */
	private void startAnimation() {
		anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_in);
		anim.setDuration(1000);
		anim.setFillAfter(true);
		rl_payInfo.startAnimation(anim);
		// imageView.startAnimation(anim);
	}
}
