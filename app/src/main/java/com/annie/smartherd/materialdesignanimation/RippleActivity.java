package com.annie.smartherd.materialdesignanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RippleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ripple);

		getSupportActionBar().setTitle("Ripple Animations");
	}

	public void dummyClick(View view) {
		// Needed to enable Ripple effect on Views.
		// Without Click event, the Ripple effect is not visible on Views.
		// Remove onClick attribute on Views and see the difference. Try it yourself.
	}
}
