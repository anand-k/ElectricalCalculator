package com.example.electricalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	public void addListenerOnButton() {

		Button button_topics = (Button) findViewById(R.id.button_topics);
		Button button_glossary = (Button) findViewById(R.id.button_glossary);
		Button button_exit = (Button) findViewById(R.id.button_exit);

		button_topics.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Topics Clicked", Toast.LENGTH_SHORT).show();
				/*start next activity */
				Intent next_activity = new Intent(getApplicationContext(),TopicsList.class);
			    startActivity(next_activity);
			}

		});
		
		button_glossary.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Glossary Clicked", Toast.LENGTH_SHORT).show();
			}

		});
		
		button_exit.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Exit Clicked", Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}		
		});
	}

	@Override
	public void onClick(View v) {
		//
	}
}
