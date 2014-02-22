package se.kth.csc.iprog.dinnerplanner.android;

import java.util.HashSet;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends Activity implements OnClickListener {
	
	MenuChooser mainView;
	int currentView;
	Dish[] menu = new Dish[3];
	DinnerModel model;
	
	ImageButton starterB;
	ImageButton mainB;
	ImageButton dessertB;
	ImageButton ingredB;
	ImageButton backB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);
		Dish starter = null;
		Dish main = null;
		Dish dessert = null;
		

		// Creating the view class instance
		model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();

		setContentView(R.layout.activity_menu);
		mainView = new MenuChooser(findViewById(R.id.activity_menu), model);
		/* Testing purposes */
		currentView = 0; // 0 for ingredients, 1 for start, 2 for main, 3
								// for dessert
		starter = model.getSelectedDish(1);
		main =  model.getSelectedDish(2);
		dessert =  model.getSelectedDish(3);

		menu[0] = starter;
		menu[1] = main;
		menu[2] = dessert;

		/* Testing end */
		double price = 0;
		for (Dish x : menu) {
			for (Ingredient ingred : x.getIngredients()) {
				price += ingred.getPrice();
			}
		}

		TextView tv = (TextView) findViewById(R.id.total_cost);
		tv.setText("Total Cost: " + price);

		starterB = ((ImageButton) findViewById(R.id.menu_starter));
		starterB.setImageResource(getResources().getIdentifier(
				starter.getImage(), "drawable", getPackageName()));
		TextView tvStarter = ((TextView) findViewById(R.id.menu_textstarter));
		tvStarter.setText(menu[0].getName());
		starterB.setOnClickListener(this);

		mainB = ((ImageButton) findViewById(R.id.menu_main));
		mainB.setImageResource(getResources().getIdentifier(main.getImage(),
				"drawable", getPackageName()));
		TextView tvMain = ((TextView) findViewById(R.id.menu_textmain));
		tvMain.setText(menu[1].getName());
		mainB.setOnClickListener(this);

		dessertB = ((ImageButton) findViewById(R.id.menu_dessert));
		dessertB.setImageResource(getResources().getIdentifier(
				dessert.getImage(), "drawable", getPackageName()));
		TextView tvDessert = ((TextView) findViewById(R.id.menu_textdessert));
		tvDessert.setText(menu[2].getName());
		dessertB.setOnClickListener(this);
		
		ingredB = ((ImageButton) findViewById(R.id.menu_ingred));
		ingredB.setOnClickListener(this);
		
		backB = ((ImageButton) findViewById(R.id.imageButton1));
		backB.setOnClickListener(this);

		swapView();
		

	}
	
	void swapView(){
		switch (currentView) {
		case 0:
			loadIngred(mainView, model, menu);
			break;
		case 1:
			loadStarter(mainView, model, menu[0]);
			break;
		case 2:
			loadMain(mainView, model, menu[1]);
			break;
		case 3:
			loadDessert(mainView, model, menu[2]);
			break;
		default:
			loadDefault(mainView);
			break;
		}
	}

	void loadIngred(MenuChooser v, DinnerModel model, Dish[] menu) {
		Set<Ingredient> allIngreds = new HashSet<Ingredient>();
		for (Dish x : menu) {
			for (Ingredient ingred : x.getIngredients()) {
				allIngreds.add(ingred);
			}
		}

		TextView content = (TextView) findViewById(R.id.menu_textcontent);
		TextView title = (TextView) findViewById(R.id.menu_textTitle);
		title.setText("Ingredients");
		StringBuilder sb = new StringBuilder();
		for (Ingredient ingred : allIngreds) {
			sb.append(ingred.getName() + " " + ingred.getQuantity() + " "
					+ ingred.getUnit() + "\n");
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
		// no default

	}

	@Override
	public void onClick(View v) {
		
		if (v==backB){
			finish();
		}
		else if (v==starterB){
			currentView=1;
		}
		else if (v==mainB){
			currentView=2;
		}
		else if (v==dessertB){
			currentView=3;
		}
		else if (v==ingredB){
			currentView=0;
		}
		
		swapView();
		
	}

}
