package com.lost.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lost.trivia.databinding.FragmentLoserBinding;

public class LoserFragment extends Fragment {

    FragmentLoserBinding binding;


    public LoserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoserBinding.inflate(inflater, container, false);
        binding.tvNombre2.setText("Lo siento " + getArguments().getString("name"));
        setOnClickListener();
        return binding.getRoot();
    }

    private void cambiarFragment(){
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.container, WelcomeFragment.newInstance());
        transaction.commit();
    }

    private void setOnClickListener(){
        binding.btnVolver.setOnClickListener(v ->{
            cambiarFragment();
        });
    }
}