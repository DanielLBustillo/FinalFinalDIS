package ufv.dis.extraordinaria.dlb;

import java.util.ArrayList;

public class Tweets {
	
	ArrayList<Tweet> tweets; 
	
	public Tweets() {
		tweets = new ArrayList<Tweet>(); 
	}
	
	public void addTweet(Tweet tw) {
		tweets.add(tw); 
	}
	
	public void removeTweet(Tweet tw) {
		tweets.remove(tw); 
	}
	
	public ArrayList<Tweet> getTweets(){
		return tweets; 
	}
	
	public int listSize() {
		return tweets.size(); 
	}

}
