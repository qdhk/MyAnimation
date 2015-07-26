/**
 * 
 */
package com.nr.myanimation.ui.custom.iosdialog;

/**
 * @author Administrator
 *仅仅引入jar包，由于缺少res下的资源文件，是不可使用的，若要使用isoDialog,还是引入所依赖的库，promptDialog-master
 */

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nr.myanimation.R;
import fynn.app.PromptDialog;

public class IosDialogActivity extends Activity implements OnClickListener {
	private Button btn_show_textview, btn_show_edittext, btn_show_listview,
			iosButton1, iosButton2, iosButton3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_iosdialog);
		// 实例化控件
		// btn_show_textview = (Button) findViewById(R.id.btn_show_textview);
		// btn_show_edittext = (Button) findViewById(R.id.btn_show_edittext);
		// btn_show_listview = (Button) findViewById(R.id.btn_show_listview);
		iosButton1 = (Button) findViewById(R.id.button1);
		iosButton2 = (Button) findViewById(R.id.button2);
		iosButton3 = (Button) findViewById(R.id.button3);
		// 设置监听
		// btn_show_textview.setOnClickListener(this);
		// btn_show_edittext.setOnClickListener(this);
		// btn_show_listview.setOnClickListener(this);
		iosButton1.setOnClickListener(this);
		iosButton2.setOnClickListener(this);
		iosButton3.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		switch (id) {
		// case R.id.btn_show_textview:
		// showTextView();
		// break;
		// case R.id.btn_show_edittext:
		// showEditText();
		// break;
		// case R.id.btn_show_listview:
		// showListView();
		// Intent intent = new Intent(MainActivity.this,
		// PicSelectActivity.class);
		// startActivityForResult(intent, 0x123);
		// Button bb = new Button(getApplicationContext());
		// WindowManager wm = (WindowManager) getApplicationContext()
		// .getSystemService("window");
		// WindowManager.LayoutParams wmParams = new
		// WindowManager.LayoutParams();
		// wmParams.type = 2002; // type是关键，这里的2002表示系统级窗口，你也可以试试2003。
		// wmParams.format = 1;
		// /**
		// * 这里的flags也很关键 代码实际是wmParams.flags |= FLAG_NOT_FOCUSABLE;
		// * 40的由来是wmParams的默认属性（32）+ FLAG_NOT_FOCUSABLE（8）
		// */
		// wmParams.flags = 40;
		// wmParams.width = 40;
		// wmParams.height = 40;
		// wm.addView(bb, wmParams);
		// break;
		case R.id.button1:
			showIos_btn1();
			break;
		case R.id.button2:
			showIos_btn2();
			break;
		case R.id.button3:
			showIos_btn3();
			break;

		default:
			break;
		}
	}

	/**
	 * 显示textview
	 */
	// private void showTextView() {
	// // 引用自定义布局
	// View v = LayoutInflater.from(this).inflate(R.layout.textview, null);
	// TextView textView = (TextView) v.findViewById(R.id.textv_content);
	// textView.setText("我是提示!");
	// myDialog = new MyDialog(this, "我是提示哦", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "我是提示",
	// Toast.LENGTH_SHORT).show();
	// // 关闭dialog
	// myDialog.dismiss();
	// }
	// });
	// // 显示dialog
	// myDialog.show();
	// }

	/**
	 * 显示edittext
	 */
	// private void showEditText() {
	// // 引用自定义布局
	// View v = LayoutInflater.from(this).inflate(R.layout.edittext, null);
	// EditText textView = (EditText) v.findViewById(R.id.edit_content);
	// myDialog = new MyDialog(this, "我是edittext", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "我是edittext",
	// Toast.LENGTH_SHORT).show();
	// myDialog.dismiss();
	// }
	// });
	// myDialog.show();
	// }

	String items[] = new String[] { "item1", "item2", "item3" };

	/**
	 * 显示listview
	 */
	// private void showListView() {
	// // 引用自定义布局
	// View v = LayoutInflater.from(this).inflate(R.layout.listview, null);
	// ListView listview = (ListView) v.findViewById(R.id.listv_content);
	// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	// android.R.layout.simple_list_item_1, items);
	// listview.setAdapter(adapter);
	// myDialog = new MyDialog(this, "我是listview", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "我是listview",
	// Toast.LENGTH_SHORT).show();
	// myDialog.dismiss();
	// }
	// });
	// myDialog.show();
	// }

	private void showIos_btn1() {
		new PromptDialog.Builder(this).setTitle("提示").setMessage("确定删除xx?")
				.setButton1("确定", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						Toast.makeText(IosDialogActivity.this, "确定", 1).show();
					}
				}).setButton2("取消", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				}).show();
	}

	private void showIos_btn2() {
		new PromptDialog.Builder(this).setTitle("提示")
				.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR)
				.setMessage("确定删除xx么?")
				.setButton1("确定", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						dialog.dismiss();
					}
				}).show();
	}

	private void showIos_btn3() {
		new PromptDialog.Builder(this).setTitle("提示")
				.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR_SKYBLUE)
				.setTitleColor(Color.BLUE)
				.setMessage("确定要退出么?\n第2行\n第3行\n第4行\n第5行")
				.setButton1("OK", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						dialog.dismiss();
					}
				}).setButton2("Cancel", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				}).setButton3("Help", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				}).show();
	}
}
