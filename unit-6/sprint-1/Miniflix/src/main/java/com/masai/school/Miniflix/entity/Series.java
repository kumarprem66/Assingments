package com.masai.school.Miniflix.entity;

public class Series {

	 	private int id;
	    private String tile;
	    private int episodes;
	    private String description;
	    
		public Series(int id, String tile, int episodes, String description) {
			super();
			this.id = id;
			this.tile = tile;
			this.episodes = episodes;
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTile() {
			return tile;
		}
		public void setTile(String tile) {
			this.tile = tile;
		}
		public int getEpisodes() {
			return episodes;
		}
		public void setEpisodes(int episodes) {
			this.episodes = episodes;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Series [id=" + id + ", tile=" + tile + ", episodes=" + episodes + ", description=" + description
					+ "]";
		}
	    
	    
		
	
}
