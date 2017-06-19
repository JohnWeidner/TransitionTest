package com.motb.transitiontest;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    Fragment mDetailCardFragment = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
    }

    boolean to;

    public void onClick( View v ) {
        Scene scene;
        ViewGroup mSceneRoot = (ViewGroup) findViewById(R.id.fragmentContainer);
        if (to) {
            Transition mFadeTransition =
                    TransitionInflater.from(this).
                            inflateTransition(R.transition.transition1);
            scene = Scene.getSceneForLayout(mSceneRoot, R.layout.fragment1, this);

            TransitionManager.go(scene, mFadeTransition);
        }
        else {
            Transition mFadeTransition =
                    TransitionInflater.from(this).
                            inflateTransition(R.transition.transition1);
            scene = Scene.getSceneForLayout(mSceneRoot, R.layout.activity2, this);
            TransitionManager.go(scene, mFadeTransition);
        }
        to = !to;
//        if ( mDetailCardFragment == null ) {
//            mDetailCardFragment = Fragment1.newInstance();
//            getSupportFragmentManager().beginTransaction()
//                    //.setCustomAnimations( R.anim.anim1, R.anim.anim2 )
//                    .replace(R.id.fragmentContainer, mDetailCardFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_NONE)
//                    .commit();
//        }
//        else {
//            getSupportFragmentManager().beginTransaction().remove( mDetailCardFragment )
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
//                    .commit();
//            mDetailCardFragment = null ;
//        }
    }
}
