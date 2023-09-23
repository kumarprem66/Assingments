package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Like;
import com.example.demo.model.Retweet;
import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.service.TweetService;

@RestController
public class TweetController {

	
	@Autowired
	TweetService tweetservice;
	
	 @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
    	
    	List<User> users = tweetservice.getAllUsers();
    	ResponseEntity<List<User>> allusers = new ResponseEntity<>(users, HttpStatus.OK);
		return allusers;
    }
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUsers(@RequestBody User user) {
		tweetservice.addUsers(user);
		return "Sucess";
	}
	
	@PostMapping("/tweet")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewTweet(@RequestBody Tweet tweet) {
		tweetservice.createTweet(tweet);
	}
	
	@PostMapping("/like")
	@ResponseStatus(HttpStatus.CREATED)
	public void likeTweet(@RequestBody Like like) {
		tweetservice.likeTweet(like);
	}
	
	
	@PostMapping("/retweet")
	@ResponseStatus(HttpStatus.CREATED)
	public void reTweet(@RequestBody Retweet retweet) {
		tweetservice.retweet(retweet);
	}
	
	@GetMapping("/tweethistory/{userid}")
	public List<Tweet> userTweetHistory(@RequestBody String userid) {
		
		return tweetservice.tweetHistory(userid);
	}
	
	
}
