package org.idnp.fragmentsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class YellowFragment extends Fragment {

    public YellowFragment() {

    }

    public static YellowFragment newInstance() {
        YellowFragment fragment = new YellowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_yellow, container, false);

        View view=inflater.inflate(R.layout.fragment_yellow, container, false);

        Button button=view.findViewById(R.id.btnAbrirActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),SecondActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}