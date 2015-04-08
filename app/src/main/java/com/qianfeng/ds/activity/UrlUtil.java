package com.qianfeng.ds.activity;

public class UrlUtil {


    // 热门-干货
    public final static String URL_HOT_SUGGEST = "http://m2.qiushibaike.com/article/list/suggest?page=";

    // 热门-嫩草
    public final static String URL_HOT_LATEST = "http://m2.qiushibaike.com/article/list/latest?page=";

    // 精华-日
    public final static String URL_ETLITE_DAY = "http://m2.qiushibaike.com/article/list/day?page=";

    // 精华-周
    public final static String URL_ETLITE_WEEK = "http://m2.qiushibaike.com/article/list/week?page=";

    // 精华-月
    public final static String URL_ETLITE_MONTH = "http://m2.qiushibaike.com/article/list/month?page=";

    // 有图有真相-硬菜
    public final static String URL_IMAGE_IMGRANK = "http://m2.qiushibaike.com/article/list/imgrank?page=";

    // 有图有真相-时令
    public final static String URL_IMAGE_IMAGES = "http://m2.qiushibaike.com/article/list/images?page=";

    public final static String[]TITLE_NAMES = {"干货", "嫩草" ,
            "日", "周", "月" , "硬菜", "时令"  };
    //头像获取(+ id前4位 + "/" + id + "/thumb/" + icon图片名.jpg)
    //userIcon======http://pic.qiushibaike.com/system/avtnew/1499/14997026/thumb/20140404194843.jpg
    public final static String URL_USER_ICON="http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
    //内容图片获取(+图片名从数字开始数4位+"/"+图片名从数字开始数全部+"/"+"/"+small或者medium+"/"+图片名)
    //====图片Url=http://pic.qiushibaike.com/system/pictures/7128/71288069/small/app71288069.jpg
    public final static String URL_IMAGE= "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";

}

 