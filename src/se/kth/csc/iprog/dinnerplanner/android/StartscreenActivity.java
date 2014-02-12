package se.kth.csc.iprog.dinnerplanner.android;


import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.view.View.*;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.DialogInterface;


public class StartscreenActivity extends Activity implements OnClickListener{
	
	Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);


		View mainView = findViewById(R.id.startscreen);
		
		setContentView(R.layout.activity_startscreen);
		
		next = (Button) mainView.findViewById(R.id.mainNext);
		next.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v==next){
			MainActivity.goToActivity(1);	
		}
		
	}


}
