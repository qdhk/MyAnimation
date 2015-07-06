package com.nr.myanimation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

/**
 * ��ȡapk��Ϣ
 * 
 * @author zhangzhp
 * 
 */
public class ApkInfoTool {
	private static final String tag = null;

	/**
	 * 
	 * @param context
	 *            Context������
	 * @param apkPath
	 *            apk��SD�е�·��
	 * @return
	 */
	public static Drawable getApkIcon(Context context, String apkPath) {

		PackageManager pm = context.getPackageManager();
		PackageInfo info = pm.getPackageArchiveInfo(apkPath,
				PackageManager.GET_ACTIVITIES);
		if (info != null) {
			ApplicationInfo appInfo = info.applicationInfo;
			appInfo.sourceDir = apkPath;
			return appInfo.loadIcon(pm);
		}
		return null;
	}

	/**
	 * ��ȡapk��VersionName
	 * 
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context) {

		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo packinfo = pm.getPackageInfo(context.getPackageName(),
					0);
			return packinfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			// todo: can't reach
			return "";
		}
	}

	/**
	 * ��ȡapk��VersionCode
	 * 
	 * @param context
	 * @return
	 */
	public static int getVersionCode(Context context) {

		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo packinfo = pm.getPackageInfo(context.getPackageName(),
					0);
			return packinfo.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * ����data/appĿ¼�±������apk��װ�ļ���SD����Ŀ¼��
	 * 
	 * @param packageName
	 * @param mActivity
	 * @throws IOException
	 */
	public static void backupApp(String packageName, Activity mActivity)
			throws IOException {
		// ���λ��
		String newFile = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + File.separator;
		String oldFile = null;
		try {
			// ԭʼλ��
			oldFile = mActivity.getPackageManager().getApplicationInfo(
					packageName, 0).sourceDir;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(newFile);
		System.out.println(oldFile);

		File in = new File(oldFile);
		File out = new File(newFile + packageName + ".apk");
		if (!out.exists()) {
			out.createNewFile();
			Log.i(tag, "�ļ����ݳɹ���" + "�����" + newFile + "Ŀ¼��");
		} else {
			Log.i(tag, "�ļ����ݳɹ���" + "�����" + newFile + "Ŀ¼��");
		}

		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);

		int count;
		// �ļ�̫��Ļ����Ҿ�����Ҫ�޸�
		byte[] buffer = new byte[256 * 1024];
		while ((count = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, count);
		}

		fis.close();
		fos.flush();
		fos.close();
	}

}
