package com.qianfeng.ds.util;

import com.qianfeng.ds.activity.R;
import java.io.File;
import android.content.Context;
import android.os.Environment;

import com.lidroid.xutils.BitmapUtils;

public class BitmapHelper {
	private static BitmapUtils bitmapUtils;
	public static void initUtils(Context context){
		bitmapUtils=new BitmapUtils(context, new File(Environment.getExternalStorageDirectory(),"3dgame").getAbsolutePath()
				, 0.25f);
		//����ʱ��ʾ��ͼƬ
		bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
		bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
		bitmapUtils.configDefaultBitmapMaxSize(100, 100);
		//���̻���Ĺ���ʱ��
		bitmapUtils.configDefaultCacheExpiry(1000*60*60*24);
		//���ӳ�ʱ
		bitmapUtils.configDefaultConnectTimeout(5000);
	}

    public static BitmapUtils getBitmapUtils() {
        return bitmapUtils;
    }
}
