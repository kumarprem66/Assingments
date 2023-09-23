package com.example.demo.model;

public class Retweet {

	
	private String retweetId;
	private String userid;
	private String tweetId;
	
	
	public Retweet(String retweetId, String userid, String tweetId) {
		super();
		this.retweetId = retweetId;
		this.userid = userid;
		this.tweetId = tweetId;
	}
	public String getRetweetId() {
		return retweetId;
	}
	public void setRetweetId(String retweetId) {
		this.retweetId = retweetId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	@Override
	public String toString() {
		return "Retweet [retweetId=" + retweetId + ", userid=" + userid + ", tweetId=" + tweetId + "]";
	}
	
	
	
	
}
