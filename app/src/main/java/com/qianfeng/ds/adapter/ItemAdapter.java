package com.qianfeng.ds.adapter;

import java.util.List;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.qianfeng.ds.activity.R;
import com.qianfeng.ds.activity.UrlUtils;
import com.qianfeng.ds.entity.ChapterBean;
import com.qianfeng.ds.util.BitmapHelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter  extends BaseAdapter{
	private Context context;
	private List<ChapterBean> data;
	
	
	public ItemAdapter(Context context,List<ChapterBean> data){
		this.context=context;
		this.data=data;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view==null){
			view=LayoutInflater.from(context).inflate(R.layout.item, parent,false);
			//
			view.setTag(new ViewHolder(view));
		}
		final ViewHolder vHolder=(ViewHolder) view.getTag();
		ChapterBean bean=data.get(position);
		vHolder.text.setText(bean.getTitle());
                BitmapHelper.getBitmapUtils().display(view, UrlUtils.home + bean.getImage(),new BitmapLoadCallBack<View>() {
                    @Override
                    public void onLoadCompleted(View view, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                        int width=bitmap.getHeight();
                        Bitmap bit=Bitmap.createBitmap(width,width,Bitmap.Config.ARGB_8888);
                        //获得一个canvas，绘制在bitmap上
                        Canvas canvas=new Canvas(bitmap);
                        Paint paint=new Paint();
                        //开启抗锯齿
                        paint.setAntiAlias(true);
                        //设置画笔的填充物
                        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
                        //画一个圆形
                        canvas.drawCircle(width/2,width/2,width/2,paint);
                        if(view instanceof ImageView){
                            vHolder.image= (ImageView) view;
                            vHolder.image.setImageBitmap(bitmap);
                        }
                    }

                    @Override
                    public void onLoadFailed(View view, String s, Drawable drawable) {

                    }
                });
		return view;
	}
	//�ظ�ʹ��
	public static class ViewHolder{
		private View itemView;
		
		private ImageView image;
		private TextView text;
		public ViewHolder(View itemView){
			this.itemView=itemView;
			ViewUtils.inject(this,itemView);
		}
	}
	public void addAll(List<ChapterBean> data){
		data.addAll(data);
		//�������
		notifyDataSetChanged();
	}
}
