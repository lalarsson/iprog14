package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuChooser implements Observer{

	View view;

	DinnerModel model; // we add class variable

	public MenuChooser(View view, DinnerModel model) {
	 // store in the class the reference to the Android View
	 this.view = view;
	 // and the reference to the model
	 this.model = model;
	 
	 // Setup the rest of the view layout
	 model.addObserver(this);
	}

	public View getView(){
		return view;
	}
	
	public DinnerModel getModel(){
		return model;
	}
	
	@Override
	public void update(Observable observable, Object data) {
	}
}
