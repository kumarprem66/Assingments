package com.prem.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prem.springproject.entities.Album;
import com.prem.springproject.entities.Artist;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Song;
import com.prem.springproject.entities.User;
import com.prem.springproject.services.SpotifyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

	
	@Autowired
	private SpotifyService spotifyService;
	
	@PostMapping("/artists")
	public ResponseEntity<Artist> addnewArtist(@RequestBody @Valid Artist artist){
		
		Artist artists = spotifyService.addArtist(artist);
		return new ResponseEntity<>(artists,HttpStatus.OK);
	}
	
	@PostMapping("/albums")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody @Valid Album album) {
		spotifyService.addAlbum(album);
	}
	
	
	@PostMapping("/songs")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody @Valid Song song) {
		spotifyService.addSong(song);
	}
	
	@PostMapping("/playlists")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody @Valid Playlist playlist) {
		spotifyService.addPlaylist(playlist);
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody @Valid User user) {
		spotifyService.addUser(user);
	}
	
	@GetMapping("/getalbums")
	@ResponseStatus(HttpStatus.OK)
	public List<Album> getAllAlbumHndler() {
		return spotifyService.getAllAlbums();
	}
	
	
	@GetMapping("/getartist")
	@ResponseStatus(HttpStatus.OK)
	public List<Artist> getAllArtistHndler() {
		return spotifyService.getAllArtist();
	}
	
	@GetMapping("/getsongs")
	@ResponseStatus(HttpStatus.OK)
	public List<Song> getAllSongHndler() {
		return spotifyService.getAllSongs();
	}
	
	
	
	
	
	
	
	
	
	
	
}
