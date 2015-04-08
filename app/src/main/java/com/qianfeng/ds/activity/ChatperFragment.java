package com.qianfeng.ds.activity;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.ds.adapter.ItemAdapter;
import com.qianfeng.ds.entity.ChapterBean;
import com.qianfeng.ds.util.DBHelper;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class ChatperFragment extends ListFragment implements OnRefreshListener{
	@ViewInject(R.id.swipe)
	private SwipeRefreshLayout swipe;
	//������
	private ItemAdapter adapter;
	//
	private HttpUtils httpUtils;
	private int typeId;
	private int page=1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            //ʵ����ViewUtils
            ViewUtils.inject(this,view);
            //������������id
            typeId=getArguments().getInt("typeId");
            //����������
            adapter=new ItemAdapter(getActivity(), new ArrayList<ChapterBean>());
            setListAdapter(adapter);
            getData();
            httpUtils=new HttpUtils();
            try {
                //ɾ��������
//                DBHelper.getDbUtils().delete(ChapterBean.class, WhereBuilder.b("typeId","=",2));
//                ChapterBean bean=new ChapterBean();
//                bean.setTitle("���ű���");
//                DBHelper.getDbUtils().update(bean,WhereBuilder.b("typeId","=",2),"title");
                Selector selector=Selector.from(ChapterBean.class);
//                if(typeId!=1){
//                    selector.where("typeId","=",typeId);
//                }
//                //����
//                selector.orderBy("sortrank",true);
//                selector.limit(30);
                //��ѯ���ݿ�����
                List<ChapterBean> list= DBHelper.getDbUtils().findAll(selector);
                if(list!=null){
                    adapter.addAll(list);
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
            //�������������¼�
            swipe.setOnRefreshListener(this);
	}

    /**
     *  ����ˢ��
     */
    @Override
    public void onRefresh() {
        getData();

    }

    private void getData() {
        httpUtils.send(HttpMethod.GET, "http://122.226.122.6/sitemap/api.php?row=30d&typeid=1s&paging=1&page=1",new RequestCallBack<String>() {
            /**
             * ����ˢ��ʧ��
             * @param exception
             * @param str
             */
            @Override
            public void onFailure(HttpException exception, String str) {
                Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
                swipe.setRefreshing(false);

            }

            @Override
            public void onSuccess(ResponseInfo<String> info) {
                try {
                    JSONObject object = new JSONObject(info.result);
                    JSONObject data = object.getJSONObject("data");
                    List<ChapterBean> beans = new ArrayList<ChapterBean>();
                    int index = 0;
                    while (!data.isNull(String.valueOf(index))) {
                        JSONObject chapter = data.getJSONObject(String.valueOf(index++));
                        ChapterBean bean = new ChapterBean();
                        bean.setId(chapter.getInt("id"));
                        bean.setTypeId(chapter.getInt("typeid"));
                        bean.setSortrank(chapter.getInt("sortrank"));
                        bean.setTitle(chapter.getString("shorttitle"));
                        bean.setImage(chapter.getString("litpic"));
                        bean.setArcurl(chapter.getString("arcurl"));
                        beans.add(bean);
                    }
                    adapter.addAll(beans);
                    try {
                        DBHelper.getDbUtils().saveOrUpdateAll(beans);
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                swipe.setRefreshing(false);
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent=new Intent(getActivity(),ActivityWeb.class);
        ChapterBean item= (ChapterBean) adapter.getItem(position);
        intent.putExtra("id",item.getId());
        startActivity(intent);
    }
}
