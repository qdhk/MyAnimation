package com.nr.myanimation.ui.custom.circlemenu;

/*
 * Copyright 2013 Csaba Szugyiczki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.nr.myanimation.R;
import com.nr.myanimation.ui.custom.circlemenu.CircleLayout.OnItemClickListener;
import com.nr.myanimation.ui.custom.circlemenu.CircleLayout.OnItemSelectedListener;

/**
 * Բ����ת�˵�(�Զ���Layout+ImageView)
 * 
 * @author Administrator
 * 
 */
public class CircleMenuMainActivity extends Activity implements
		OnItemSelectedListener, OnItemClickListener {
	private TextView selectedTextView;
	private CircleLayout circleMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setView();
		initView();
		setListener();
	}

	public void setView() {
		setContentView(R.layout.activity_custom_circleimage_main);

	}

	public void initView() {
		circleMenu = (CircleLayout) findViewById(R.id.main_circle_layout);

		selectedTextView = (TextView) findViewById(R.id.main_selected_textView);
		selectedTextView.setText(((CircleImageView) circleMenu
				.getSelectedItem()).getName());

	}

	public void setListener() {
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);

	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {
		selectedTextView.setText(name);
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		Toast.makeText(getApplicationContext(),
				getResources().getString(R.string.start_app) + " " + name,
				Toast.LENGTH_SHORT).show();
	}

}
