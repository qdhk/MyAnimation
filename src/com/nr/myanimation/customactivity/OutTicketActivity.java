/**
 * 
 */
package com.nr.myanimation.customactivity;

import com.nr.myanimation.R;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
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
		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
		// // ͸��״̬��
		// getWindow().addFlags(
		// WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// // ͸��������
		// getWindow().addFlags(
		// WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		// }
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_imitate_outticket);
		rl_payInfo = (RelativeLayout) findViewById(R.id.rl_payInfo);
		imageView = (ImageView) findViewById(R.id.iv_success);
		newThread();
	}

	/**
	 * �����õ�,�������߳�
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
	 * ������ӡСƱ����
	 */
	private void startAnimation() {
		anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_in);
		anim.setDuration(1000);
		anim.setFillAfter(true);
		rl_payInfo.startAnimation(anim);
		// imageView.startAnimation(anim);
	}
}
