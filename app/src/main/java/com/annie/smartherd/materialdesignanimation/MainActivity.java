package com.annie.smartherd.materialdesignanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo, imgProfilePic;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo = (ImageView) findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = (ImageView) findViewById(R.id.imgAnnie);
        txvShared = (TextView) findViewById(R.id.txvSharedElement);

        setupWindowAnimations();
    }

    private void setupWindowAnimations() {

        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }

    public void checkRippleAnimation(View view) {
        Intent intent = new Intent(this, RippleActivity.class);
        startActivity(intent);
    }

    public void sharedElementTransition(View view) {

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pair[1] = new Pair<View, String>(txvShared, "smartherd_shared");
        pair[2] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(MainActivity.this, SharedElementActivity.class);
        startActivity(i, options.toBundle());
    }

    public void explodeTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(i, options.toBundle());

    }

    public void explodeTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        i.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(i, options.toBundle());

    }

    public void slideTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        i.putExtra(Constants.KEY_TITLE, "Slide By Java Code");
        startActivity(i, options.toBundle());
    }

    public void slideTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        i.putExtra(Constants.KEY_TITLE, "Slide By XML");
        startActivity(i, options.toBundle());
    }

    public void fadeTransitionByJava(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
        i.putExtra(Constants.KEY_TITLE, "Fade By Java");
        startActivity(i, options.toBundle());

    }

    public void fadeTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
        i.putExtra(Constants.KEY_TITLE, "Fade By XML");
        startActivity(i, options.toBundle());

    }
}
