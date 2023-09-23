package com.prem.springproject.services;

import java.util.List;

import com.prem.springproject.entities.PlayListDto;
import com.prem.springproject.entities.Playlist;
import com.prem.springproject.entities.Song;

public interface UserService {

	
	public void createPlaylist(Integer userid, Playlist playlist);
	
	public void addSongstoPlaylist(Integer userid, Integer playlistid, Song song);
	
	public List<Song> fetchUserPlayHistory(Integer userid);
	
	public void updatePlaylistDetails(Integer playlistid, Integer userid,PlayListDto playListDto);
}
