package com.prem.springproject.services;

import java.util.List;

import com.prem.springproject.entities.Album;
import com.prem.springproject.entities.Artist;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Song;
import com.prem.springproject.entities.User;
import com.prem.springproject.exception.SpotifyException;

public interface SpotifyService {
	
	public Artist addArtist(Artist artist) throws SpotifyException;

	public Album addAlbum(Album album) throws SpotifyException;
	
	public Song addSong(Song song) throws SpotifyException;
	
	public User addUser(User user) throws SpotifyException;
	
	public Playlist addPlaylist(Playlist playlist) throws SpotifyException;
	
	public List<Song> getAllSongs();
	
	public List<Album> getAllAlbums();
	
	public List<Artist> getAllArtist();
	
	
}
