package com.example.thangla;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	GridView grid;
	String[] web = { "Macbook \n $400", "Dell Notebook \n $200",
			"Bracelet \n $1", "Iphone6 \n $100", "Soccer Ball \n $10" };
	int[] imageId = {R.drawable.macbook,R.drawable.dell,R.drawable.bracelet,R.drawable.iphone,
			R.drawable.logo};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
		grid = (GridView) findViewById(R.id.grid);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						"You Clicked at " + web[+position], Toast.LENGTH_SHORT)
						.show();

			}
		});

	}

}
