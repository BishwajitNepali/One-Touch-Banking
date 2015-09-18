package com.example.thangla;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BalanceCheck extends Activity {
	String displayText;
	TextView tv;
	ProgressBar pg;
	String acc,pin_code;
	
	
	
	int pin=Integer.parseInt(pin_code);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_balance);
		 acc=getIntent().getStringExtra("ACCOUNT_NUMBER");
		 pin_code=getIntent().getStringExtra("PIN");
		 
		 int pin=Integer.parseInt(pin_code);

		 
		 Log.e("Check in Balance Check", "Acc"+acc+"pin"+pin+"");
		

		tv = (TextView) findViewById(R.id.display_text);
		pg = (ProgressBar) findViewById(R.id.progressBar1);

		AsyncCallWS task = new AsyncCallWS();
		// Call execute
		task.execute();

	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {
		@Override
		protected Void doInBackground(String... params) {
			// Invoke webservice
			
		
			 
			 
			displayText = WebService.invokeHelloWorldWSBalance(acc, pin,
					"BalanceEnquiry");
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// Set response
			tv.setText(displayText);
			// Make ProgressBar invisible
			pg.setVisibility(View.INVISIBLE);
		}

		@Override
		protected void onPreExecute() {
			// Make ProgressBar invisible
			pg.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}

	}

}
