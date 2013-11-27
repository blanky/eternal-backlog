package com.example.eternalbacklog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String LOG = "LogNotes";
	private static final String SERIES = "series_list.csv";
	private static final String EPISODES = "episode_list.csv";
	private ArrayList<Episode> episode_list = new ArrayList<Episode>();
	private ArrayList<Series> series_list = new ArrayList<Series>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(((this.seriesListAvailable())!=(this.episodeListAvailable()))) {
			corruptSaves();
		}
		if(!(this.seriesListAvailable())) {
			nothingToRead();
		} else {
			readLists();
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
					corruptSaves();
				}
				Episode temp_episode = new Episode(temp_storage[0], 
						Integer.parseInt(temp_storage[1]));
				episode_list.add(temp_episode);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void readSeries() {
		// TODO Auto-generated method stub
		
	}




	private void nothingToRead() {
		
	}
}
