package com.lost.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lost.trivia.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    private static WelcomeFragment fragment;
    private TriviaFragment triviaFragment;
    private Bundle bundle;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance(){

        fragment = new WelcomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false);


        binding.btnComenzar.setOnClickListener(v ->{

            bundle = new Bundle();
            bundle.putString("name", binding.editTextTextPersonName.getText().toString());

            triviaFragment = new TriviaFragment();
            triviaFragment.setArguments(bundle);

            changeFragment();
        });


        return binding.getRoot();
    }

    private void changeFragment(){

        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, triviaFragment).commit();

    }
}