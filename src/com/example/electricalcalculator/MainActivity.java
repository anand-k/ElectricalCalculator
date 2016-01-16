package com.example.electricalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	public void addListenerOnButton() {

		Button button = (Button) findViewById(R.id.button_1);

		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Button_1 Clicked", Toast.LENGTH_SHORT).show();
			}

		});
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "Button 1 Clicked", Toast.LENGTH_SHORT).show();
	}

}
