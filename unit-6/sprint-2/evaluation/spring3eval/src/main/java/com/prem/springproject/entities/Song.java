package com.prem.springproject.entities;

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
public class Song {

	
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
	@NotEmpty(message = "albumId is important")
	private String albumId;
	
	@NotNull
	@NotEmpty(message = "duration is important")
	@Min(value = 1,message = "can't ne less than 1 min")
	private Double duration;
	

	@ManyToOne
	private Album albums;
	
	@ManyToOne
	private Artist artists;
	
	
	
	
	
	
	

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

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Album getAlbums() {
		return albums;
	}

	public void setAlbums(Album albums) {
		this.albums = albums;
	}

	public Artist getArtists() {
		return artists;
	}

	public void setArtists(Artist artists) {
		this.artists = artists;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


