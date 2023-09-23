package com.example.demo.model;

public class Like {

	
	private String likeId;
	private String userId;
	private String tweetId;
	public Like(String likeId, String userId, String tweetId) {
		super();
		this.likeId = likeId;
		this.userId = userId;
		this.tweetId = tweetId;
	}
	public String getLikeId() {
		return likeId;
	}
	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", userId=" + userId + ", tweetId=" + tweetId + "]";
	}
	
	
	
	
}
