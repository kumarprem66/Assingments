package com.example.demo.model;

import java.util.List;

public class Tweet {

	
	private String tweetId;
	private String userId;
	private String content;
	private List<String> likedUserId;
	private List<String> retweetUserId;
	
	public Tweet(String tweetId, String userId, String content, List<String> likedUserId, List<String> retweetUserId) {
		super();
		this.tweetId = tweetId;
		this.userId = userId;
		this.content = content;
		this.likedUserId = likedUserId;
		this.retweetUserId = retweetUserId;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getLikedUserId() {
		return likedUserId;
	}
	public void setLikedUserId(List<String> likedUserId) {
		this.likedUserId = likedUserId;
	}
	public List<String> getRetweetUserId() {
		return retweetUserId;
	}
	public void setRetweetUserId(List<String> retweetUserId) {
		this.retweetUserId = retweetUserId;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", userId=" + userId + ", content=" + content + ", likedUserId="
				+ likedUserId + ", retweetUserId=" + retweetUserId + "]";
	}
	
	
}
