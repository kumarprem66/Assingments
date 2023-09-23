package com.prem.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prem.springproject.entities.PlayListDto;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Song;
import com.prem.springproject.services.UserService;

@RestController
@RequestMapping("/spotifyUser")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/users/{userid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createPlaylistHandler(@PathVariable Integer userid, @RequestBody Playlist playlist) {
		userService.createPlaylist(userid,playlist);
	}
	
	@PostMapping("/users/{userid}{playlistid}")
	@ResponseStatus(HttpStatus.OK)
	public void addSongToPlaylistHandler(@PathVariable Integer userid,@PathVariable Integer playlistid,  @RequestBody Song song) {
		userService.addSongstoPlaylist(userid, userid, song);
	}
	
	
	
	@GetMapping("/users/{userid}")
	@ResponseStatus(HttpStatus.OK)
	public List<Song> fetchUserPlayHistoryHandler(@PathVariable Integer userid) {
		List<Song> songs  = userService.fetchUserPlayHistory(userid);
		return songs;
	}
	
	
	@PutMapping("/users/{userid}{playlistid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updatePlaylistDetailsHandler(@PathVariable Integer playlistid, @PathVariable Integer userid, @RequestBody PlayListDto playlist) {
		userService.updatePlaylistDetails(playlistid,userid,playlist);
	}
}
