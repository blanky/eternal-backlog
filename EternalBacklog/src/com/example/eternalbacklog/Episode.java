package com.example.eternalbacklog;

public class Episode {
	private Integer episode_no;
	private String series_name;
	public Episode(String series_name, Integer episode_no) {
		setEpisodeNumber(episode_no);
		setSeriesName(series_name);
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
	
	public void setEpisodeNumber(Integer episode_no) {
		this.episode_no = episode_no;
	}
	
	public void setSeriesName(String series_name) {
		this.series_name = series_name;
	}
	
}
