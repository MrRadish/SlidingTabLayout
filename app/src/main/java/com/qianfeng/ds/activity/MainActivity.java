package com.qianfeng.ds.activity;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ResInject;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.ds.adapter.ViewpagerAdapter;
import com.qianfeng.ds.util.BitmapHelper;
import com.qianfeng.ds.util.DBHelper;
import com.qianfeng.ds.view.SlidingTabLayout;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

	@ViewInject(R.id.slidingtab)
    private SlidingTabLayout sliding;
    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
//    @ResInject(id=R.string.helloworld,type = ResType.String)
//    private String hello;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        //初始化数据库
        DBHelper.initUtils(this);
        BitmapHelper.initUtils(this);
        viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager()));
        sliding.setViewPager(viewPager);
    }

}
