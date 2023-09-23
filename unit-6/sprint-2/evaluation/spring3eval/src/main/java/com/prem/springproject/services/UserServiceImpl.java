package com.prem.springproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prem.springproject.entities.PlayListDto;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Privacy;
import com.prem.springproject.entities.Song;
import com.prem.springproject.entities.User;
import com.prem.springproject.exception.SpotifyException;
import com.prem.springproject.repository.PlaylistRepo;
import com.prem.springproject.repository.SongRepo;
import com.prem.springproject.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private PlaylistRepo playlistRepo;
	
	@Autowired
	private SongRepo songrepo;
	
	@Autowired
	private UserRepo userrepo;

	
	@Override
	public void createPlaylist(Integer userid, Playlist playlist) {
	
		if(playlist==null) throw new SpotifyException("playlist is null");
		Optional<User> uopt = userrepo.findById(userid);
		if(uopt.isEmpty()) {
			throw new SpotifyException("user is not available");
		}
		uopt.get().getPlaylist().add(playlist);
		playlistRepo.save(playlist);
//		log.info("playlist is created");
		
	}

	@Override
	public void addSongstoPlaylist(Integer userid, Integer playlistid, Song song) {
		if(song==null) throw new SpotifyException("song is null");
		Optional<User> uopt = userrepo.findById(userid);
		Optional<Song> sonopt = songrepo.findById(song.getId());
		Optional<Playlist> popt = playlistRepo.findById(playlistid);
		if(uopt.isEmpty() || popt.isEmpty() || sonopt.isEmpty()) {
			throw new SpotifyException("user or playlist or song is not available");
		}
		
		popt.get().getSongsId().add(song.getId());
		
		songrepo.save(song);
		
		
	}

	@Override
	public List<Song> fetchUserPlayHistory(Integer userid) {
		
		Optional<User> uopt = userrepo.findById(userid);
		
		if(uopt.isEmpty()) {
			throw new SpotifyException("user  is not available");
		}
		
		List<Playlist> playlist = uopt.get().getPlaylist();
		List<Song> songs = new ArrayList<>();
		for(Playlist s : playlist) {
			songs.addAll(s.getSongs());
		}
		
		return songs;
		
		
	}

	@Override
	public void updatePlaylistDetails(Integer playlistid, Integer userid,PlayListDto playListDto) {
		Optional<User> uopt = userrepo.findById(userid);
		Optional<Playlist> popt = playlistRepo.findById(playlistid);
		if(uopt.isEmpty() || popt.isEmpty()) {
			throw new SpotifyException("user or playlist is not available");
		}
		
		popt.get().setDescription(playListDto.getDescription());
		popt.get().setName(playListDto.getName());
		if(playListDto.getPrivacy().equals(Privacy.PRIVATE)) {
			popt.get().setPrivacy(Privacy.PUBLIC);
		}else {
			popt.get().setPrivacy(Privacy.PRIVATE);
		}
		
		playlistRepo.save(popt.get());
		
	}

}
