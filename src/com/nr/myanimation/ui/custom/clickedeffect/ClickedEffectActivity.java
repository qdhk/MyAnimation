/**
 * 
 */
package com.nr.myanimation.ui.custom.clickedeffect;

/**
 * @author Administrator
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.nr.myanimation.R;

public class ClickedEffectActivity extends Activity {
	/** Called when the activity is first created. */
	ClickedEffectImagview joke;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setView();
		initView();
		setListener();
	}

	public void setView() {
		setContentView(R.layout.activity_custom_click_deflect_main);

	}

	public void initView() {
		joke = (ClickedEffectImagview) findViewById(R.id.c_joke);

	}

	public void setListener() {
		joke.setOnClickIntent(new ClickedEffectImagview.OnViewClick() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(ClickedEffectActivity.this, "ÊÂ¼þ´¥·¢", 0).show();
				System.out.println("1");
			}
		});

	}
}