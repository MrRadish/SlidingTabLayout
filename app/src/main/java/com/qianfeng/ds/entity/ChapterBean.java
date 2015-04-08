package com.qianfeng.ds.entity;
import java.io.Serializable;

import android.R.integer;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.db.annotation.Unique;

@Table(name="Chapter")
public class ChapterBean implements Serializable{
        //列名不写为属性名，推荐写列名
        @Id(column = "id")
        //取消自增属性
        @NoAutoIncrement
	private int id;
        @Column(column = "typeId")
	private int typeId;
        @Column(column = "sortrank")
	private int sortrank;
        @Column(column = "title")
        @NotNull
        @Unique//不可重复
	private String title;
        @Column(column = "image")
	private String image;
        @Column(column = "arcurl")
	private String arcurl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getSortrank() {
		return sortrank;
	}
	public void setSortrank(int sortrank) {
		this.sortrank = sortrank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getArcurl() {
		return arcurl;
	}
	public void setArcurl(String arcurl) {
		this.arcurl = arcurl;
	}
	
	
}
