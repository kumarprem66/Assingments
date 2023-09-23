package com.prem.springproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prem.springproject.entities.Album;
import com.prem.springproject.entities.Artist;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Song;
import com.prem.springproject.entities.User;
import com.prem.springproject.exception.SpotifyException;
import com.prem.springproject.repository.AlbumRepo;
import com.prem.springproject.repository.ArtistRepo;
import com.prem.springproject.repository.PlaylistRepo;
import com.prem.springproject.repository.SongRepo;
import com.prem.springproject.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpotifyServiceImpl implements SpotifyService{
	
	
	@Autowired
	private PlaylistRepo playlistRepo;
	
	@Autowired
	private SongRepo songrepo;
	
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private AlbumRepo albumRepo;
	@Autowired
	private ArtistRepo artistrepo;

	@Override
	public Artist addArtist(Artist artist) throws SpotifyException {
	
		
		if(artist==null) throw new SpotifyException("artist is null");
		artistrepo.save(artist);
		
//		log.info("artsit is added");

		return artist;
	}

	@Override
	public Album addAlbum(Album album) throws SpotifyException {
		if(album==null) throw new SpotifyException("album is null");
		albumRepo.save(album);
//		log.info("album is added");
		return album;
	}

	@Override
	public Song addSong(Song song) throws SpotifyException {
		if(song==null) throw new SpotifyException("song is null");
		songrepo.save(song);
//		log.info("song is added");
		return song;
	}

	@Override
	public User addUser(User user) throws SpotifyException {
		if(user==null) throw new SpotifyException("user is null");
		userrepo.save(user);
//		log.info("user is added");
		return user;
	}

	@Override
	public Playlist addPlaylist(Playlist playlist) throws SpotifyException {
		if(playlist==null) throw new SpotifyException("playlist is null");
		playlistRepo.save(playlist);
//		log.info("playlist is added");
		return playlist;
	}
	
	@Override
	public List<Artist> getAllArtist() {
		Pageable pageable = PageRequest.of(0, 5,Sort.by("name").ascending());
		List<Artist> artistList = artistrepo.findAll(pageable).getContent();
		if(artistList.isEmpty()) throw new SpotifyException("Empty artist list");
		return artistList; 
	}
	
	@Override
	public List<Song> getAllSongs() {
		Pageable pageable = PageRequest.of(0, 5,Sort.by("name").ascending());
		List<Song> songlist = songrepo.findAll(pageable).getContent();
		if(songlist.isEmpty()) throw new SpotifyException("Empty song list");
		return songlist; 
	}
	
	@Override
	public List<Album> getAllAlbums() {
		Pageable pageable = PageRequest.of(0, 5,Sort.by("name").ascending());
		List<Album> albumlist = albumRepo.findAll(pageable).getContent();
		if(albumlist.isEmpty()) throw new SpotifyException("Empty Album list");
		return albumlist; 
	}

}
