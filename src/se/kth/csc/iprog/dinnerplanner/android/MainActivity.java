package se.kth.csc.iprog.dinnerplanner.android;


import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;


public class MainActivity extends Activity{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		// Creating the view class instance
		/*DinnerModel model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();*/

		//setContentView(R.layout.activity_main);
		
		Intent startscreen = new Intent(this, StartscreenActivity.class);
		startActivity(startscreen);
		
		
	}

	public static void goToActivity(int i) {
		switch(i){
		case '1':
			
			break;
		}
		
	}


}
