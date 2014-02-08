package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
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
		Dish starter = null;
		Dish main = null;
		Dish dessert = null;

		// Creating the view class instance
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();

		/* CODE TO DYNAMICALLY LOAD DATA FROM MODEL INTO VIEW FOR MENUCHOOSER! 
		setContentView(R.layout.activity_main);
		MenuChooser mainView = new MenuChooser(findViewById(R.id.menuchooser),
				model);

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

		 CODE TO DYNAMICALLY LOAD DATA FROM MODEL INTO VIEW FOR MENU! */

		setContentView(R.layout.activity_menu);
		MenuChooser mainView = new MenuChooser(findViewById(R.id.menu), model);
		int currentView = 0; // 0 for ingredients, 1 for start, 2 for main, 3
								// for dessert

		switch (currentView) {
		case 0:
			loadIngred(mainView, model, new Dish[] { starter, main, dessert });
		case 1:
			loadStarter(mainView, model, starter);
		case 2:
			loadMain(mainView, model, main);
		case 3:
			loadDessert(mainView, model, dessert);
		default:
			loadDefault(mainView);
		}

	}

	void loadIngred(MenuChooser v, DinnerModel m, Dish[] d) {

	}

	void loadStarter(MenuChooser v, DinnerModel m, Dish d) {

	}

	void loadMain(MenuChooser v, DinnerModel m, Dish d) {

	}

	void loadDessert(MenuChooser v, DinnerModel m, Dish d) {

	}

	void loadDefault(MenuChooser v) {

	}

}
