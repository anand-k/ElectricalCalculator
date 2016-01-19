package com.example.electricalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class TopicsList extends Activity {

	ListView listview;
	public final static String selectedActor_ID="will Keep Actor ID";
	private ProgressBar progressbar;
	
	String[] values = new String[] { 
			"Electrical Machines", 
			"Control Systems", 
			"Power Systems",
			"Power Generation and Utilization",
			"Digital Systems", 
			"Operational Amplifiers", 
			"Electronic Devices", 
    };
	
	Integer[] imageId = {
            R.drawable.electrical_machines,
            R.drawable.control_system,
            R.drawable.power_systems,
            R.drawable.power_gen_util,
            R.drawable.digital_sys,
            R.drawable.opamps,
            R.drawable.electronic_devices
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicslist_activity);

		/* ListView class which is capable of displaying a scrollable list of items */
		listview = (ListView) findViewById(R.id.list);	
		progressbar=(ProgressBar)findViewById(R.id.progress_bar);
		
		progressbar.setVisibility(View.GONE);
		
		CustomList adapter = new
                CustomList(this, values, imageId);
		
		/*
		 * An adapter manages the data model and adapts it to the individual entries in the widget. 
		 * An adapter extends the BaseAdapter class.
		 * Every line in the widget displaying the data consists of a layout which can be as complex as you want. 
		 * A typical line in a list has an image on the left side and two text lines in the middle as depicted in the following graphic.
		 */
		
		/*
		 * The ArrayAdapter class can handle a list or array of Java objects as input. 
		 * Every Java object is mapped to one row. By default, it maps the toString() 
		 * method of the object to a view in the row layout.
		 */

		listview.setAdapter(adapter);
		
		/* To react to selections in the list, 
		 * set an OnItemClickListener to your ListView */
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			//@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				progressbar.setVisibility(View.VISIBLE);
				Toast.makeText(getApplicationContext(),
					      "Clicked " + values[position], Toast.LENGTH_SHORT)
					      .show();
				
				Intent next_activity = new Intent(getApplicationContext(),SpinnerActivity.class);
                // you have to pass the actor id to next activity
                // you can get this actor id from argument of type "long"
				next_activity.putExtra(selectedActor_ID, String.valueOf(id));
			    startActivity(next_activity);
			}
		});
	}
}
