package com.prem.springproject.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	@NotNull
	@NotEmpty(message = "name is important")
	private String name;
	
	@NotNull
	@NotEmpty(message = "artistId is important")
	private String artistId;
	
	@NotNull
	@NotEmpty(message = "duration is important")
	
	private Date releasedate;
	

	@OneToMany(mappedBy = "albums",cascade = CascadeType.ALL)
	private List<Song> songs;

	@ManyToOne
	private Artist artist;


	
	
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArtistId() {
		return artistId;
	}


	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}





	public Date getReleasedate() {
		return releasedate;
	}


	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}


	public List<Song> getSongs() {
		return songs;
	}


	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
