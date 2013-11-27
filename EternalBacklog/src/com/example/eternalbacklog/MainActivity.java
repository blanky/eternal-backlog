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
		this.listAvailable();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private boolean listAvailable() {
		File temp_file = new File("list.csv");
		try {
			Log.d(LOG, temp_file.getCanonicalPath());
			if(temp_file.exists()) {
				return true;
			}
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d(LOG, "Path lookup failed");
		}
		return false;
		
	}

}
