package se.kth.csc.iprog.dinnerplanner.android;

import java.util.HashSet;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
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
		Dish[] menu = new Dish[3];

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
		/* Testing purposes*/
		int currentView = 3; // 0 for ingredients, 1 for start, 2 for main, 3 for dessert
		starter = model.getDish("French toast", 1);
		main = model.getDish("Meat balls", 2);
		dessert = model.getDish("Ice Cream", 3);
		
		menu[0] = starter; 
		menu[1] = main; 
		menu[2] = dessert;
		
		/*Testing end*/
		double price = 0;
		for(Dish x : menu){
			for(Ingredient ingred : x.getIngredients()){
				price += ingred.getPrice();
			}
		}
		
		TextView tv = (TextView) findViewById(R.id.total_cost);
		tv.setText("Total Cost: " + price);
		
		ImageButton starterB = ((ImageButton) findViewById(R.id.menu_starter));
		starterB.setImageResource(getResources().getIdentifier(starter.getImage(), "drawable", getPackageName()));
		TextView tvStarter = ((TextView) findViewById(R.id.menu_textstarter));
		tvStarter.setText(starter.getName());
		
		
		ImageButton mainB = ((ImageButton) findViewById(R.id.menu_main));
		mainB.setImageResource(getResources().getIdentifier(main.getImage(), "drawable", getPackageName()));
		TextView tvMain = ((TextView) findViewById(R.id.menu_textmain));
		tvMain.setText(main.getName());
		
		ImageButton dessertB = ((ImageButton) findViewById(R.id.menu_dessert));
		dessertB.setImageResource(getResources().getIdentifier(dessert.getImage(), "drawable", getPackageName()));
		TextView tvDessert = ((TextView) findViewById(R.id.menu_textdessert));
		tvDessert.setText(dessert.getName());
		
	
		switch (currentView) {
		case 0: loadIngred(mainView, model, menu);break;
		case 1: loadStarter(mainView, model, starter);break;
		case 2: loadMain(mainView, model, main);break;
		case 3: loadDessert(mainView, model, dessert);break;
		default:loadDefault(mainView);break;
		}

	}

	void loadIngred(MenuChooser v, DinnerModel model, Dish[] menu) {
		Set<Ingredient> allIngreds = new HashSet<Ingredient>();
		for(Dish x : menu){
			for(Ingredient ingred : x.getIngredients()){
				allIngreds.add(ingred);
			}
		}
		
		TextView content = (TextView) findViewById(R.id.menu_textcontent);
		TextView title = (TextView) findViewById(R.id.menu_textTitle);
		title.setText("Ingredients");
		StringBuilder sb = new StringBuilder();
		for(Ingredient ingred : allIngreds){
				sb.append(ingred.getName()+" "+ingred.getQuantity()+" " + ingred.getUnit() +"\n");
		}
		content.setText(sb.toString());
		
	}

	void loadStarter(MenuChooser v, DinnerModel m, Dish d) {
		TextView content = (TextView) findViewById(R.id.menu_textcontent);
		TextView title = (TextView) findViewById(R.id.menu_textTitle);
		title.setText("Starter Course");
		String s = d.getDescription().replace(". ", ".\n\n");
		content.setText(d.getName() + "\n" + s);
	}

	void loadMain(MenuChooser v, DinnerModel m, Dish d) {
		TextView content = (TextView) findViewById(R.id.menu_textcontent);
		TextView title = (TextView) findViewById(R.id.menu_textTitle);
		title.setText("Main Course");
		String s = d.getDescription().replace(". ", ".\n\n");
		content.setText(d.getName() + "\n" + s);

	}

	void loadDessert(MenuChooser v, DinnerModel m, Dish d) {
		TextView content = (TextView) findViewById(R.id.menu_textcontent);
		TextView title = (TextView) findViewById(R.id.menu_textTitle);
		title.setText("Dessert Course");
		String s = d.getDescription().replace(". ", ".\n\n");
		content.setText(d.getName() + "\n" + s);

	}

	void loadDefault(MenuChooser v) {
		//no default

	}

}
