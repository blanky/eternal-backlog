package com.example.eternalbacklog;

public class Series {
	private int next_to_watch;
	private int total_eps;
	private int internal_count;
	private String series_name;
	
	public Series(String series_name, int total_eps, int next_to_watch) {
		this.setN2W(next_to_watch);
		this.setIC(next_to_watch);
		this.setSN(series_name);
		this.setTE(total_eps);
	}

	public int getN2W() {
		return next_to_watch;
	}
	
	public int getTE() {
		return total_eps;
	}

	public int getIC() {
		return internal_count;
	}
	
	public String getSN() {
		return series_name;
	}
	
	
	public void setN2W(int next_to_watch) {
		this.next_to_watch = next_to_watch;
	}

	public void setTE(int total_eps) {
		this.total_eps = total_eps;
	}

	public void setIC(int internal_count) {
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
