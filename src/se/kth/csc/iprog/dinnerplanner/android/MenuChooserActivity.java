package se.kth.csc.iprog.dinnerplanner.android;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuChooser;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MenuChooserActivity extends Activity implements
		NumberPicker.OnValueChangeListener, OnClickListener, Observer {

	MenuChooser chooser;
	LinkedList<ImageButton> listWithButtons = new LinkedList<ImageButton>();
	NumberPicker np;
	Button compBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		// Creating the view class instance
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();

		chooser = new MenuChooser(findViewById(R.id.activity_menuchooser),
				model);

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
			image.setOnClickListener(this);
			image.setTag("" + dish.getName());
			listWithButtons.add(image);
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
			image.setOnClickListener(this);
			image.setTag("" + dish.getName());
			listWithButtons.add(image);
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
			image.setOnClickListener(this);
			image.setTag("" + dish.getName());
			listWithButtons.add(image);
		}

		ll1.invalidate();
		ll2.invalidate();
		ll3.invalidate();

		np = (NumberPicker) findViewById(R.id.numberPicker1);
		np.setMaxValue(99);
		np.setMinValue(0);
		np.setValue(0);
		np.setOnValueChangedListener(this);
		chooser.getModel().addObserver(this);
		
		compBtn = (Button) findViewById(R.id.compBtn);
		compBtn.setOnClickListener(this);

	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		chooser.getModel().setNumberOfGuests(picker.getValue());

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setText("Total Price: "
				+ chooser.getModel().getNumberOfGuests()
				* chooser.getModel().getTotalMenuPrice() + "kr");
	}

	@Override
	public void onClick(View v) {
		
		if(((v.getClass().toString()).equalsIgnoreCase("class android.widget.Button")) && v==compBtn){
			Intent MC = new Intent(this,MenuActivity.class);
			startActivity(MC);
			//finish();
		}
		
		/* IMAGEBUTTON */
		if(((v.getClass().toString()).equalsIgnoreCase("class android.widget.ImageButton"))){
		for (Dish d : chooser.getModel().getDishes()) {
			if ((v.getTag().toString()).equalsIgnoreCase(d.getName())) {
				for (Dish m : chooser.getModel().getDishesOfType(d.getType())) {
					for(ImageButton img : listWithButtons){
						if((img.getTag().toString()).equalsIgnoreCase(m.getName())){
							img.setSelected(false);
							img.setImageAlpha(50);
						}
					}
					
				}
				v.setSelected(true);
				((ImageButton)v).setImageAlpha(255);
				chooser.getModel().setSelectedDish(d);
			}

		}}
	}
}
