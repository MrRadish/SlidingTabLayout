package com.qianfeng.ds.adapter;

import com.qianfeng.ds.activity.ChatperFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewpagerAdapter extends FragmentPagerAdapter {

    public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
    }
     private static final String[] chapter={
             "文章首页", "新闻", "游戏杂谈", "硬件信息",
             "游戏前瞻", "游戏评测", "原创精品", "游戏盘点", "时事焦点", "攻略中心",
     };
     private static final int[] typeIds ={
             1	,
             2	,
             151	,
             152	,
             153	,
             154	,
             196	,
             197	,
             199	,
             25	,
     };
     @Override
     public Fragment getItem(int position) {
         Fragment fragment = new ChatperFragment();
         Bundle bundle = new Bundle();
         bundle.putString("chapter", chapter[position]);
         bundle.putInt("typeId", typeIds[position]);
         fragment.setArguments(bundle);
         return fragment;
     }

     @Override
     public int getCount() {
         return chapter.length;
     }

     @Override
     public CharSequence getPageTitle(int position) {
         return chapter[position];
     }

}
