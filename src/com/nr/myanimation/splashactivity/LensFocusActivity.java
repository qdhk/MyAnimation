/**
 * 
 */
package com.nr.myanimation.splashactivity;

import com.nr.myanimation.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Administrator
 * 
 */
public class LensFocusActivity extends Activity {
	private ImageView imageView_pic;
	private TextView textView_desc;

	/**
	 * �����л��Ķ���
	 */
	private Animation mFadeIn;
	private Animation mFadeInScale;
	private Animation mFadeOut;

	/**
	 * ����ͼƬ
	 */
	private Drawable mPicture_1;
	private Drawable mPicture_2;
	private Drawable mPicture_3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_lens_focus);
		imageView_pic = (ImageView) findViewById(R.id.imageView_pic);
		textView_desc = (TextView) findViewById(R.id.textView_desc);
		init();
	}

	/**
	 * ��ʼ������
	 */
	private void initAnim() {
		mFadeIn = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
		mFadeIn.setDuration(1000);
		mFadeInScale = AnimationUtils.loadAnimation(this,
				R.anim.welcome_fade_in_scale);
		mFadeInScale.setDuration(4000);
		mFadeOut = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_out);
		mFadeOut.setDuration(1000);
	}

	/**
	 * ��ʼ��ͼƬ
	 */

	private void initPicture() {
		mPicture_1 = getResources().getDrawable(R.drawable.pic_01);
		mPicture_2 = getResources().getDrawable(R.drawable.pic_02);
		mPicture_3 = getResources().getDrawable(R.drawable.pic_03);
	}

	private void init() {
		initAnim();
		initPicture();
		/**
		 * ����տ�ʼ��ʾ������
		 */
		imageView_pic.setImageDrawable(mPicture_1);
		textView_desc.setText("��ʱ������...");
		imageView_pic.startAnimation(mFadeIn);
		setListener();
	}

	/**
	 * �����¼�
	 */
	public void setListener() {
		/**
		 * �����л�ԭ��:��ʼʱ���õ�һ�����ֶ���,����һ����������ʱ��ʼ�ڶ����Ŵ󶯻�,���ڶ�����������ʱ���õ�������������,
		 * ��������������ʱ�޸���ʾ�����ݲ������µ��õ�һ������,�Ӷ��ﵽѭ��Ч��
		 */
		mFadeIn.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				imageView_pic.startAnimation(mFadeInScale);
			}
		});
		mFadeInScale.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				imageView_pic.startAnimation(mFadeOut);
			}
		});
		mFadeOut.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				/**
				 * ������ʵ��Щд�Ĳ���,�����Բ��ø���ķ�ʽ���жϵ�ǰ��ʾ���ǵڼ���,�Ӷ��޸�����,
				 * ������ֻ�Ǽ򵥵Ĳ��û�ȡ��ǰ��ʾ��ͼƬ�������жϡ�
				 */
				if (imageView_pic.getDrawable().equals(mPicture_1)) {
					textView_desc.setText("�¶�������...");
					imageView_pic.setImageDrawable(mPicture_2);
				} else if (imageView_pic.getDrawable().equals(mPicture_2)) {
					textView_desc.setText("���������...");
					imageView_pic.setImageDrawable(mPicture_3);
				} else if (imageView_pic.getDrawable().equals(mPicture_3)) {
					textView_desc.setText("��ʱ������...");
					imageView_pic.setImageDrawable(mPicture_1);
				}
				imageView_pic.startAnimation(mFadeIn);
			}
		});

	}
}
