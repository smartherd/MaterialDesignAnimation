package com.annie.smartherd.materialdesignanimation;

import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {

	Constants.TransitionType type;
	String toolbarTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// inside your activity (if you did not enable transitions in your theme)
		// For AppCompat getWindow must be called before calling super.OnCreate
		// Must be called before setContentView
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition);

		initPage();

		initAnimation();

		// For overlap between Exiting  MainActivity.java and Entering TransitionActivity.java
		getWindow().setAllowEnterTransitionOverlap(false);
	}

	private void initPage() {

		type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
		toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);

		Button btnExit = (Button) findViewById(R.id.exit_button);
		btnExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finishAfterTransition();
			}
		});

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(toolbarTitle);
	}

	@Override
	public boolean onSupportNavigateUp() {
		finishAfterTransition();
		return true;
	}

	private void initAnimation() {

		switch (type) {

			case ExplodeJava: { // For Explode By Code
				Explode enterTransition = new Explode();
				enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
				getWindow().setEnterTransition(enterTransition);
				break;
			}

			case ExplodeXML: { // For Explode By XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTansition);
                break;
			}

			case SlideJava: { // For Slide By Code
                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.TOP);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
			}

			case SlideXML: { // For Slide by XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(enterTansition);
                break;
			}

			case FadeJava: { // For Fade By Code
                Fade enterTransition = new Fade();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
                getWindow().setEnterTransition(enterTransition);
                break;
			}

			case FadeXML: { // For Fade by XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(enterTansition);
                break;

			}
		}

	}
}
