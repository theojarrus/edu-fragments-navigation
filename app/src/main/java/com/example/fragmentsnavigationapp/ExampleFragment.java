package com.example.fragmentsnavigationapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentsnavigationapp.databinding.FragmentExampleBinding;

public class ExampleFragment extends Fragment {

    private static final String ARG_COLOR = "arg_color";

    private FragmentExampleBinding binding;

    public static ExampleFragment newInstance(String color) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_COLOR, color);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentExampleBinding.inflate(inflater);
        String color = requireArguments().getString(ARG_COLOR);
        binding.getRoot().setBackgroundColor(Color.parseColor(color));
        binding.text.setText(color);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
