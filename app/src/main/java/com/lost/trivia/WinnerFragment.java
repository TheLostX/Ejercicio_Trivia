package com.lost.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lost.trivia.databinding.FragmentWinnerBinding;

public class WinnerFragment extends Fragment {

    FragmentWinnerBinding binding;


    public WinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentWinnerBinding.inflate(inflater, container, false);
        binding.textView4.setText( "Has ganado " +  getArguments().getString("name"));

        setOnClickListener();

        return binding.getRoot();
    }

    private void setOnClickListener(){

        binding.button.setOnClickListener( v ->{
            changeFragment();
        });
    }

    private void changeFragment(){

        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, WelcomeFragment.newInstance()).commit();
    }


}