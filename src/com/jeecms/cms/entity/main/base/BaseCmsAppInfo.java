package com.jeecms.cms.entity.main.base;

import java.io.Serializable;
import java.util.Set;

import com.jeecms.cms.entity.main.CmsModelItem;

public abstract class BaseCmsAppInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static String REF = "CmsAppInfo";
	public static String PROP_CHANNELID = "channelId";
	public static String PROP_TOPICNAME = "topicName";
	public static String PROP_SHORTNAME = "shortName";
	public static String PROP_KEYWORDS = "keywords";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_TITLEIMG = "titleImg";
	public static String PROP_CONTENTIMG = "contentImg";
	public static String PROP_TPLCONTENT = "tplContent";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_ISRECOMMEND = "isRecommend";
	public static String PROP_ID = "id";

	// primary key
	private java.lang.Integer id;

	private java.lang.String channelId;
	private java.lang.String topicName;
	private java.lang.String shortName;
	private java.lang.String keywords;
	private java.lang.String description;
	private java.lang.String titleImg;
	private java.lang.String contentImg;
	private java.lang.String tplContent;
	private java.lang.Integer priority;
	private java.lang.String isRecommend;

	public BaseCmsAppInfo(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	public BaseCmsAppInfo(String channelId, String topicName, String shortName,
			String keywords, String description, String titleImg,
			String contentImg, String tplContent, Integer priority,
			String isRecommend, int hashCode, Integer id,
			Set<CmsModelItem> items) {
		super();
		this.setChannelId(channelId);
		this.setTopicName(topicName);
		this.setShortName(shortName);
		this.setKeywords(keywords);
		this.setDescription(description);
		this.setTitleImg(titleImg);
		this.setContentImg(contentImg);
		this.setTplContent(tplContent);
		this.setPriority(priority);
		this.setIsRecommend(isRecommend);

		this.id = id;

	}

	public BaseCmsAppInfo() {
		initialize();
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getChannelId() {
		return channelId;
	}

	public void setChannelId(java.lang.String channelId) {
		this.channelId = channelId;
	}

	public java.lang.String getTopicName() {
		return topicName;
	}

	public void setTopicName(java.lang.String topicName) {
		this.topicName = topicName;
	}

	public java.lang.String getShortName() {
		return shortName;
	}

	public void setShortName(java.lang.String shortName) {
		this.shortName = shortName;
	}

	public java.lang.String getKeywords() {
		return keywords;
	}

	public void setKeywords(java.lang.String keywords) {
		this.keywords = keywords;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(java.lang.String titleImg) {
		this.titleImg = titleImg;
	}

	public java.lang.String getContentImg() {
		return contentImg;
	}

	public void setContentImg(java.lang.String contentImg) {
		this.contentImg = contentImg;
	}

	public java.lang.String getTplContent() {
		return tplContent;
	}

	public void setTplContent(java.lang.String tplContent) {
		this.tplContent = tplContent;
	}

	public java.lang.Integer getPriority() {
		return priority;
	}

	public void setPriority(java.lang.Integer priority) {
		this.priority = priority;
	}

	public java.lang.String getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(java.lang.String isRecommend) {
		this.isRecommend = isRecommend;
	}

	protected void initialize() {
	}
}
