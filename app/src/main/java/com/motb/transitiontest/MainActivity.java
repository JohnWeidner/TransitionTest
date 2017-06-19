package com.motb.transitiontest;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    Fragment mDetailCardFragment = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
    }


    public void onClick( View v ) {
        if ( mDetailCardFragment == null ) {
            mDetailCardFragment = Fragment1.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations( R.anim.anim1, R.anim.anim2 )
                    .replace(R.id.fragmentContainer, mDetailCardFragment)
                    .setTransition(FragmentTransaction.TRANSIT_NONE)
                    .commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().remove( mDetailCardFragment )
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                    .commit();
            mDetailCardFragment = null ;
        }
    }
}
