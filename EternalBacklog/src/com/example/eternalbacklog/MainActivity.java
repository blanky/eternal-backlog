package com.example.eternalbacklog;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String LOG = "LogNotes";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.seriesListAvailable();
		this.episodeListAvailable();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private boolean seriesListAvailable() {
		File series_file = new File("series_list.csv");
		try {
			Log.d(LOG, series_file.getCanonicalPath());
			if(series_file.exists()) {
				Log.d(LOG, "series file exists");
				return true;
			}
			Log.d(LOG, "series file doesn't exist");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d(LOG, "Path lookup failed");
		}
		return false;
	}
	
	private boolean episodeListAvailable() {
		File series_file = new File("episode_list.csv");
		try {
			Log.d(LOG, series_file.getCanonicalPath());
			if(series_file.exists()) {
				Log.d(LOG, "episode file exists");
				return true;
			}
			Log.d(LOG, "episode file doesn't exist");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d(LOG, "Path lookup failed");
		}
		return false;
	}

}
