package com.motb.transitiontest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.*;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.animation;
import static android.R.attr.translationY;
import static android.R.transition.fade;
import static android.content.ContentValues.TAG;

public class Fragment1 extends Fragment {

    public static Fragment1 newInstance( ) {
        return new Fragment1();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment1, container, false);
        fragmentView.setOnClickListener( new View.OnClickListener(){
            public void onClick( final View v ) {
                startDetailActivity( (ViewGroup) getActivity().getWindow().getDecorView() );
            }
        });

        return fragmentView;
    }


    public void startDetailActivity( final ViewGroup v ) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                    new Pair( v.findViewById(R.id.charlie), "iv1"),
                    new Pair( v.findViewById(R.id.arc1), "rv1" ),
                    new Pair( v.findViewById(R.id.arc2), "rv2" )
            ) ;
            startActivity( new Intent( getActivity(), Activity2.class ), options.toBundle() );
    }

}
