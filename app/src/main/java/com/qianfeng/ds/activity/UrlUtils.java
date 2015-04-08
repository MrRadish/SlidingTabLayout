package com.qianfeng.ds.activity;

/**
 * Created by Jash on 14-12-28.
 */
public class UrlUtils {
    public static final String home = "http://122.226.122.6";
    private static final String charape = "http://122.226.122.6/sitemap/api.php?row=%d&typeid=%s&paging=1&page=%d";
    public static String getChapter(int row,String typeid, int page){
        return String.format(charape,row,typeid,page);
    }
}
