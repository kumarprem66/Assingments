package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.example.demo.exception.InvalidEmailException;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Like;
import com.example.demo.model.Retweet;
import com.example.demo.model.Tweet;
import com.example.demo.model.User;

import jakarta.annotation.PostConstruct;

@Service
public class TweetService {

	
	private final Map<String,User> users = new HashMap<>();
	private final Map<String,Tweet> tweets = new HashMap<>();
	private final Map<String,Like> likes = new HashMap<>();
	private final Map<String,Retweet> retweets = new HashMap<>();
//	private List<String> liked = new ArrayList<>();
//	private List<String> retweet = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		
		User user = new User("12","prem","premkr4034@gmail.com");
		users.put(user.getUsuerId(), user);
		
		List<String> liked = new ArrayList<>();
		List<String> retweet = new ArrayList<>();
		Tweet tweet = new Tweet("123","12","this tweet not not fair",liked,retweet);
		
		Like like = new Like("344","12","123");
		likes.put(like.getLikeId(), like);
		
		Retweet res = new Retweet("989","12","123");
		retweets.put(res.getRetweetId(), res);
		
	}
	
	public List<User> getAllUsers(){
		
		Collection<User> values = users.values();
		List<User> users = new ArrayList<>(values);
		
		return users;
	}
	
	public void addUsers(User user) {
		validateUser(user);
		users.put(user.getUsuerId(), user);
	}
	
	public void createTweet(Tweet tweet) {
		validateTweet(tweet);
		
		tweets.put(tweet.getTweetId(), tweet);
		
		
	}
	
	public void likeTweet(Like like) {
		validateLike(like);
		for(Tweet t : tweets.values()) {
			if(t.getTweetId().equals(like.getTweetId())) {
				List<String> liked = t.getLikedUserId();
				liked.add(like.getUserId());
				t.setLikedUserId(liked);
				tweets.put(t.getTweetId(), t);
				break;
			}
		}
		
		likes.put(like.getLikeId(),like);
	}

	
	
	public void retweet(Retweet res) {
		validateReTweet(res);
		for(Tweet t : tweets.values()) {
			if(t.getTweetId().equals(res.getTweetId())) {
				List<String> retweet = t.getRetweetUserId();
				retweet.add(res.getUserid());
				t.setRetweetUserId(retweet);
				tweets.put(t.getTweetId(), t);
				break;
			}
		}
		
		retweets.put(res.getRetweetId(), res);
	}
	
	
	public List<Tweet> tweetHistory(String userid) {
		
		if(users.containsKey(userid)) {
			throw new NotFoundException("user with this id is not available");
		}
		List<Tweet> tweethistorylist = new ArrayList<>();
		for(Tweet tweet : tweets.values()) {
			if(tweet.getUserId().equals(userid)) {
				tweethistorylist.add(tweet);
			}
		}
		
		return tweethistorylist;
	}
	
	
	
	private void validateReTweet(Retweet res) {
		
		if(res.getTweetId()==null || res.getRetweetId() == null || res.getUserid() == null) {
			throw new NotFoundException("not a valid Retweet");
		}
		
		if(!users.containsKey(res.getUserid())) {
			
			throw new NotFoundException("user not exist with given id");
		}
		
		if(!tweets.containsKey(res.getTweetId())) {
			
			throw new NotFoundException("Tweet not exist with given id");
		}
		
		
	}

	private void validateLike(Like like) {
		
		
		if(like.getTweetId()==null || like.getUserId() == null || like.getLikeId() == null) {
			throw new NotFoundException("not a valid like");
		}
		
		if(!users.containsKey(like.getUserId())) {
			
			throw new NotFoundException("user not exist with given id");
		}
		
		if(!tweets.containsKey(like.getTweetId())) {
			
			throw new NotFoundException("Tweet not exist with given id");
		}
	}

	private void validateTweet(Tweet tweet) {

		if(tweet.getUserId() == null || tweet.getTweetId() == null) {
		
			throw new InvalidInputException("userid or tweet id is empty");
		}
		
		
		
		if(!users.containsKey(tweet.getUserId())) {
			throw new NotFoundException("user is not in the database");
		}

	
		if(!StringUtils.hasText(tweet.getContent())) {
			throw new InvalidInputException("Tweet must have some content");
		}
		
		
	}

	private void validateUser(User user) {
		
		if(!StringUtils.hasText(user.getName())) {
			throw new InvalidInputException("user has no name");
		}
		if(Pattern.matches("^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$", user.getEmail())) {
			throw new InvalidEmailException("please provide valid email");
		}
		
	}
	
}
