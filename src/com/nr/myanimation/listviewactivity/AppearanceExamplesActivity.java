/**
 * 
 */
package com.nr.myanimation.listviewactivity;

import java.util.ArrayList;

import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.AlphaInAnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingLeftInAnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingRightInAnimationAdapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nr.myanimation.R;

/**
 * @author Administrator
 * 
 */
public class AppearanceExamplesActivity extends Activity {
	private BaseAdapter mAdapter;

	private ListView mListView;

	private ListView mCurrentListView;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listviews_appearanceexample);

		mListView = (ListView) findViewById(R.id.activity_appearanceexample_listview);

		mCurrentListView = mListView;
		mAdapter = new MyAdapter(this, getItems());
		setAlphaAdapter();
		setLeftAdapter();
	}

	public ListView getListView() {
		return mListView;
	}

	private void setAlphaAdapter() {
		AnimationAdapter animAdapter = new AlphaInAnimationAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	private void setLeftAdapter() {
		AnimationAdapter animAdapter = new SwingLeftInAnimationAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	private void setRightAdapter() {
		AnimationAdapter animAdapter = new SwingRightInAnimationAdapter(
				mAdapter);
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	private void setBottomAdapter() {
		AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(
				mAdapter);
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	private void setBottomRightAdapter() {
		AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(
				new SwingRightInAnimationAdapter(mAdapter));
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	private void setScaleAdapter() {
		AnimationAdapter animAdapter = new ScaleInAnimationAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentListView);
		mCurrentListView.setAdapter(animAdapter);
	}

	public ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			items.add(i);
		}
		return items;
	}

	private static class MyAdapter extends ArrayAdapter<Integer> {

		private Context mContext;

		public MyAdapter(Context context, ArrayList<Integer> items) {
			super(items);
			mContext = context;
		}

		@Override
		public long getItemId(int position) {
			return getItem(position).hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) convertView;
			if (tv == null) {
				tv = (TextView) LayoutInflater.from(mContext).inflate(
						R.layout.activity_listviews_list_row, parent, false);
			}
			tv.setText("This is row number " + getItem(position));
			return tv;
		}
	}

	/* Non-ListViewAnimations related stuff below */

	private class AnimSelectionAdapter extends ArrayAdapter<String> {

		public AnimSelectionAdapter() {
			addAll("Alpha", "Left", "Right", "Bottom", "Bottom right", "Scale");
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) convertView;
			if (tv == null) {
				tv = (TextView) LayoutInflater.from(
						AppearanceExamplesActivity.this).inflate(
						android.R.layout.simple_list_item_1, parent, false);
				tv.setTextColor(Color.BLACK);
			}

			tv.setText(getItem(position));

			return tv;
		}
	}
}
