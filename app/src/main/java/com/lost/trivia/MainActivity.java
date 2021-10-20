package com.lost.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.lost.trivia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private WelcomeFragment welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setContentView(binding.getRoot());

        loadWelcomeFragment();
    }

    private void loadWelcomeFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if(welcome == null){
            welcome = new WelcomeFragment();
        }
        transaction.add(R.id.container, welcome);
        transaction.addToBackStack(null).commit();

    }

    private void initBinding(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
    }
}