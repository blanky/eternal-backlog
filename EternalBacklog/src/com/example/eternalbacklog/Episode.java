package com.example.eternalbacklog;

public class Episode {
	private Integer episode_no;
	private String series_name;
	public Episode() {
		
	}
	
	public Integer getEpisodeNumber() {
		return episode_no;
	}
	
	public String getSeriesName() {
		return series_name;
	}
	
	public String getEpisode() {
		return series_name + ": Episode " + episode_no.toString();
	}
	
	
}
