package com.xjj.http;

public class CibaPojo {
	private String sid;
	private String tts;
	private String content;
	private String note;
	private String love;
	private String translation;
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	private String picture;
	private String picture2;
	private String caption;
	private String dateline;
	private String s_pv;
	private String sp_pv;
	private TagPojo[] tags;
	private String fenxiang_img;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTts() {
		return tts;
	}
	public void setTts(String tts) {
		this.tts = tts;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getDateline() {
		return dateline;
	}
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	public String getS_pv() {
		return s_pv;
	}
	public void setS_pv(String s_pv) {
		this.s_pv = s_pv;
	}
	public String getSp_pv() {
		return sp_pv;
	}
	public void setSp_pv(String sp_pv) {
		this.sp_pv = sp_pv;
	}
	public TagPojo[] getTags() {
		return tags;
	}
	public void setTags(TagPojo[] tags) {
		this.tags = tags;
	}
	public String getFenxiang_img() {
		return fenxiang_img;
	}
	public void setFenxiang_img(String fenxiang_img) {
		this.fenxiang_img = fenxiang_img;
	}
}
