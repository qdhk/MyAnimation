/**
 * 
 */
package com.nr.myanimation.ui.custom.iosdialog;

/**
 * @author Administrator
 *��������jar��������ȱ��res�µ���Դ�ļ����ǲ���ʹ�õģ���Ҫʹ��isoDialog,���������������Ŀ⣬promptDialog-master
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
		// ʵ�����ؼ�
		// btn_show_textview = (Button) findViewById(R.id.btn_show_textview);
		// btn_show_edittext = (Button) findViewById(R.id.btn_show_edittext);
		// btn_show_listview = (Button) findViewById(R.id.btn_show_listview);
		iosButton1 = (Button) findViewById(R.id.button1);
		iosButton2 = (Button) findViewById(R.id.button2);
		iosButton3 = (Button) findViewById(R.id.button3);
		// ���ü���
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
		// wmParams.type = 2002; // type�ǹؼ��������2002��ʾϵͳ�����ڣ���Ҳ��������2003��
		// wmParams.format = 1;
		// /**
		// * �����flagsҲ�ܹؼ� ����ʵ����wmParams.flags |= FLAG_NOT_FOCUSABLE;
		// * 40��������wmParams��Ĭ�����ԣ�32��+ FLAG_NOT_FOCUSABLE��8��
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
	 * ��ʾtextview
	 */
	// private void showTextView() {
	// // �����Զ��岼��
	// View v = LayoutInflater.from(this).inflate(R.layout.textview, null);
	// TextView textView = (TextView) v.findViewById(R.id.textv_content);
	// textView.setText("������ʾ!");
	// myDialog = new MyDialog(this, "������ʾŶ", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "������ʾ",
	// Toast.LENGTH_SHORT).show();
	// // �ر�dialog
	// myDialog.dismiss();
	// }
	// });
	// // ��ʾdialog
	// myDialog.show();
	// }

	/**
	 * ��ʾedittext
	 */
	// private void showEditText() {
	// // �����Զ��岼��
	// View v = LayoutInflater.from(this).inflate(R.layout.edittext, null);
	// EditText textView = (EditText) v.findViewById(R.id.edit_content);
	// myDialog = new MyDialog(this, "����edittext", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "����edittext",
	// Toast.LENGTH_SHORT).show();
	// myDialog.dismiss();
	// }
	// });
	// myDialog.show();
	// }

	String items[] = new String[] { "item1", "item2", "item3" };

	/**
	 * ��ʾlistview
	 */
	// private void showListView() {
	// // �����Զ��岼��
	// View v = LayoutInflater.from(this).inflate(R.layout.listview, null);
	// ListView listview = (ListView) v.findViewById(R.id.listv_content);
	// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	// android.R.layout.simple_list_item_1, items);
	// listview.setAdapter(adapter);
	// myDialog = new MyDialog(this, "����listview", v, new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// Toast.makeText(getApplicationContext(), "����listview",
	// Toast.LENGTH_SHORT).show();
	// myDialog.dismiss();
	// }
	// });
	// myDialog.show();
	// }

	private void showIos_btn1() {
		new PromptDialog.Builder(this).setTitle("��ʾ").setMessage("ȷ��ɾ��xx?")
				.setButton1("ȷ��", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						Toast.makeText(IosDialogActivity.this, "ȷ��", 1).show();
					}
				}).setButton2("ȡ��", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				}).show();
	}

	private void showIos_btn2() {
		new PromptDialog.Builder(this).setTitle("��ʾ")
				.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR)
				.setMessage("ȷ��ɾ��xxô?")
				.setButton1("ȷ��", new PromptDialog.OnClickListener() {

					@Override
					public void onClick(Dialog dialog, int which) {
						dialog.dismiss();
					}
				}).show();
	}

	private void showIos_btn3() {
		new PromptDialog.Builder(this).setTitle("��ʾ")
				.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR_SKYBLUE)
				.setTitleColor(Color.BLUE)
				.setMessage("ȷ��Ҫ�˳�ô?\n��2��\n��3��\n��4��\n��5��")
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
