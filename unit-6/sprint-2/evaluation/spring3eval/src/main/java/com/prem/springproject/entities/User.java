package com.prem.springproject.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	@NotNull
	@NotEmpty(message = "name is important")
	private String name;
	
	@NotNull
	@NotEmpty(message = "email is important")
	@Email
	private String email;
	
	@NotNull
	@NotEmpty(message = "password is important")
	private String password;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Playlist> playlist;


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Playlist> getPlaylist() {
		return playlist;
	}


	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}
	
	
	

	
}
