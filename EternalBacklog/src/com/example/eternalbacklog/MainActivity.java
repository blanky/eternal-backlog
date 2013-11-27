package com.example.eternalbacklog;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String LOG = "LogNotes";
	private static final String SERIES = ".series_list.csv";
	private static final String EPISODES = ".episode_list.csv";
	private ArrayList<Episode> episode_list = new ArrayList<Episode>();
	private ArrayList<Series> series_list = new ArrayList<Series>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(((this.seriesListAvailable())!=(this.episodeListAvailable()))) {
			corruptSaves();
			setNextEpisodeText("Corrupted saves.");
		}
		if(this.seriesListAvailable()) {
			readLists();
			setNextEpisodeText("You should watch " 
					+ episode_list.get(0).getEpisode() + " next.");
		} else {
			nothingToRead();
			setNextEpisodeText("You have nothing to watch.");
		}
		
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private boolean seriesListAvailable() {
		File series_file = new File(SERIES);
		if(series_file.exists()) {
			Log.d(LOG, "series file exists");
			return true;
		}
		Log.d(LOG, "series file doesn't exist");
		return false;
	}
	
	private boolean episodeListAvailable() {
		File series_file = new File(EPISODES);
		if(series_file.exists()) {
			Log.d(LOG, "episode file exists");
			return true;
		}
		Log.d(LOG, "episode file doesn't exist");
		return false;
	}
	
	private void corruptSaves() {
		
	}
	
	private void readLists() {
		readSeries();
		readEpisodes();
	}
	
	

	private void readEpisodes() {
		try {
			FileReader episode_reader = new FileReader(EPISODES);
			@SuppressWarnings("resource")
			Scanner episode_scanner = new Scanner(episode_reader);
			while(episode_scanner.hasNextLine()) {
				String[] temp_storage = episode_scanner.nextLine().split(",");
				if(temp_storage.length != 2) {
					throw new Exception();
				}
				Episode temp_episode = new Episode(temp_storage[0], 
						Integer.parseInt(temp_storage[1]));
				episode_list.add(temp_episode);
			}
			episode_scanner.close();
			episode_reader.close();
		} catch (Exception e) {
			corruptSaves();
		}
	}




	private void readSeries() {
		try {
			FileReader series_reader = new FileReader(SERIES);
			@SuppressWarnings("resource")
			Scanner series_scanner = new Scanner(series_reader);
			while(series_scanner.hasNextLine()) {
				String[] temp_storage = series_scanner.nextLine().split(",");
				if(temp_storage.length != 3) {
					throw new Exception();
				}
				Series temp_series = new Series(temp_storage[0], 
						Integer.parseInt(temp_storage[1]), 
						Integer.parseInt(temp_storage[2]));
				series_list.add(temp_series);
			}
			series_scanner.close();
			series_reader.close();
		} catch (Exception e) {
			corruptSaves();
		}
	}

	private void nothingToRead() {
		
	}
	
	private void setNextEpisodeText(String text) {
		TextView textView = (TextView) findViewById(R.id.next_episode_text);
		textView.setText(text);
	}
}
