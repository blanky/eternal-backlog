package com.example.eternalbacklog;

public class Series {
	private Integer next_to_watch;
	private Integer total_eps;
	private Integer internal_count;
	private String series_name;
	
	public Series(String series_name, Integer total_eps, Integer next_to_watch) {
		this.setN2W(next_to_watch);
		this.setIC(next_to_watch);
		this.setSN(series_name);
		this.setTE(total_eps);
	}

	public Integer getN2W() {
		return next_to_watch;
	}
	
	public Integer getTE() {
		return total_eps;
	}

	public Integer getIC() {
		return internal_count;
	}
	
	public String getSN() {
		return series_name;
	}
	
	
	public void setN2W(Integer next_to_watch) {
		this.next_to_watch = next_to_watch;
	}

	public void setTE(Integer total_eps) {
		this.total_eps = total_eps;
	}

	public void setIC(Integer internal_count) {
		this.internal_count = internal_count;
	}

	public void setSN(String series_name) {
		this.series_name = series_name;
	}
	
	public boolean incrementIC() {
		if(this.getIC() == this.getTE()) {
			return false;
		} else {
			this.setIC(this.getIC() + 1);
			return true;
		}
	}
	
}
