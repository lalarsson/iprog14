package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        
    	// Creating the view class instance
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        
        
        /* CODE TO DYNAMICALLY LOAD DATA FROM MODEL INTO VIEW FOR MENUCHOOSER!
        ExampleView mainView = new ExampleView(findViewById(R.id.menuchooser), model);
        
        LinearLayout ll1 = (LinearLayout) findViewById(R.id.linearLayoutViewStarter);
   	 	for(Dish dish : model.getDishesOfType(1)){
   	 		ImageButton image = new ImageButton(this);
   	 		image.setClickable(true);
   	 		image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
   	 		image.setPadding(-5, 0, -5, 0);
   	 		image.setImageResource(getResources().getIdentifier(dish.getImage(),"drawable", getPackageName()));
   	 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80, 80);
   	 		image.setLayoutParams(layoutParams);
   	 		
   	 		ll1.addView(image);
   	 	}
   	 	
   	 	
   	 	LinearLayout ll2 = (LinearLayout) findViewById(R.id.linearLayoutViewMain);
	 	for(Dish dish : model.getDishesOfType(2)){
	 		ImageButton image = new ImageButton(this);
	 		image.setClickable(true);
	 		image.setPadding(-5, 0, -5, 0);
	 		image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
	 		image.setImageResource(getResources().getIdentifier(dish.getImage(),"drawable", getPackageName()));
	 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80, 80);
   	 		image.setLayoutParams(layoutParams);
	 		ll2.addView(image);
	 	}
	 	
	 	LinearLayout ll3 = (LinearLayout) findViewById(R.id.linearLayoutViewDessert);
   	 	for(Dish dish : model.getDishesOfType(3)){
   	 		ImageButton image = new ImageButton(this);
   	 		image.setClickable(true);
   	 		image.setPadding(-5, 0, -5, 0);
   	 		image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
   	 		image.setImageResource(getResources().getIdentifier(dish.getImage(),"drawable", getPackageName()));
   	 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80, 80);
	 		image.setLayoutParams(layoutParams);
   	 		ll3.addView(image);
   	 	}
   	 	
   	 	ll1.invalidate();
   	 	ll2.invalidate();
   	 	ll3.invalidate();
   	 	*/
    }

}
