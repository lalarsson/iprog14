package se.kth.csc.iprog.dinnerplanner.android;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		Intent startscreen = new Intent(this, StartScreenActivity.class);
		startActivity(startscreen);
			
	}

}
