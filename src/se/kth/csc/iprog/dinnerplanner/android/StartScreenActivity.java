package se.kth.csc.iprog.dinnerplanner.android;


import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.view.View.*;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;


public class StartScreenActivity extends Activity implements OnClickListener{
	
	Button nextBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_startscreen);
		
		nextBtn = (Button) findViewById(R.id.nextBtn);
		nextBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v==nextBtn){
			Intent MC = new Intent(this,MenuChooserActivity.class);
			startActivity(MC);
			finish();
		}
		
	}


}
