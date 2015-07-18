package com.nr.myanimation.adapter;

import com.nr.myanimation.base.ContantValue;
import com.nr.myanimation.customactivity.JellyPagerFragment;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class JellyFragPagerAdapter extends FragmentPagerAdapter {

	public JellyFragPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Bundle bundle = new Bundle();
		bundle.putInt(ContantValue.keyString, ContantValue.images[arg0
				% getCount()]);
		Fragment frag = new JellyPagerFragment();
		frag.setArguments(bundle);
		return frag;
	}

	@Override
	public int getCount() {
		return 5;
	}
}
