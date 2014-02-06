package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class ExampleView {

	View view;

	DinnerModel model; // we add class variable

	public ExampleView(View view, DinnerModel model) {
	 // store in the class the reference to the Android View
	 this.view = view;
	 // and the reference to the model
	 this.model = model;
	 
	 // Setup the rest of the view layout
	}

}
