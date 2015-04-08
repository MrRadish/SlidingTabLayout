package com.qianfeng.ds.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lidroid.xutils.DbUtils;

/**
 * Created by Administrator on 2015/3/11.
 */
public class DBHelper {

    private static DbUtils dbUtils;
    public static void initUtils(Context context){
        dbUtils=DbUtils.create(context,"3dmgame.db");
        //debug开关（打印sql语句，发布之前关闭）
        dbUtils.configDebug(true);
        //事务开关
        dbUtils.configAllowTransaction(true);
    }

    public static DbUtils getDbUtils() {
        return dbUtils;
    }
}
