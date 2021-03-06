package com.nr.myanimation.utils;

import android.app.Activity;
import android.widget.Toast;

public class ToastUtils {
	public static void showToastInThread(final Activity context,
			final String msg) {
		context.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, msg, 0).show();
			}

		});
	}
}
