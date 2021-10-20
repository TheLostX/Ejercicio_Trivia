package com.lost.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lost.trivia.databinding.FragmentTriviaBinding;

public class TriviaFragment extends Fragment {

    FragmentTriviaBinding binding;
    private String nombre;


    public TriviaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTriviaBinding.inflate(inflater, container, false);
        nombre = getArguments().getString("name");
        binding.tvNombre.setText("Holaaa " + nombre);
        setOnClickListener();

        return binding.getRoot();
    }

    private void elegirAlternativa() {

        Bundle bundle = new Bundle();
        bundle.putString("name", nombre);

        LoserFragment loserFragment = new LoserFragment();
        loserFragment.setArguments(bundle);

        WinnerFragment winnerFragment = new WinnerFragment();
        winnerFragment.setArguments(bundle);

        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if(binding.radioButton7.isChecked() || binding.radioButton8.isChecked() || binding.radioButton9.isChecked()){
            transaction.replace(R.id.container, loserFragment).commit();
        }
        else if (binding.radioButton10.isChecked()){
            transaction.replace(R.id.container, winnerFragment).commit();
        }

    }

    private void setOnClickListener() {
        binding.button2.setOnClickListener(v -> {

            elegirAlternativa();
        });
    }

}