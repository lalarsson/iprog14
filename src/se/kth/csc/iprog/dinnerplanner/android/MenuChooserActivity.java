package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MenuChooserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);
	

		// Creating the view class instance
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();

		setContentView(R.layout.activity_menuchooser);

		LinearLayout ll1 = (LinearLayout) findViewById(R.id.linearLayoutViewStarter);
		for (Dish dish : model.getDishesOfType(1)) {
			ImageButton image = new ImageButton(this);
			image.setClickable(true);
			image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
			image.setPadding(-5, 0, -5, 0);
			image.setImageResource(getResources().getIdentifier(
					dish.getImage(), "drawable", getPackageName()));
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					80, 80);
			image.setLayoutParams(layoutParams);

			ll1.addView(image);
		}

		LinearLayout ll2 = (LinearLayout) findViewById(R.id.linearLayoutViewMain);
		for (Dish dish : model.getDishesOfType(2)) {
			ImageButton image = new ImageButton(this);
			image.setClickable(true);
			image.setPadding(-5, 0, -5, 0);
			image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
			image.setImageResource(getResources().getIdentifier(
					dish.getImage(), "drawable", getPackageName()));
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					80, 80);
			image.setLayoutParams(layoutParams);
			ll2.addView(image);
		}

		LinearLayout ll3 = (LinearLayout) findViewById(R.id.linearLayoutViewDessert);
		for (Dish dish : model.getDishesOfType(3)) {
			ImageButton image = new ImageButton(this);
			image.setClickable(true);
			image.setPadding(-5, 0, -5, 0);
			image.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
			image.setImageResource(getResources().getIdentifier(
					dish.getImage(), "drawable", getPackageName()));
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					80, 80);
			image.setLayoutParams(layoutParams);
			ll3.addView(image);
		}

		ll1.invalidate();
		ll2.invalidate();
		ll3.invalidate();

	}

}
