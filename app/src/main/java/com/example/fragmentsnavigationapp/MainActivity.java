package com.example.fragmentsnavigationapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentsnavigationapp.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(v -> startFragment(Action.ADD, binding.backStackCheckbox.isChecked(), Objects.requireNonNull(binding.colorText.getText()).toString()));
        binding.replace.setOnClickListener(v -> startFragment(Action.REPLACE, binding.backStackCheckbox.isChecked(), Objects.requireNonNull(binding.colorText.getText()).toString()));
        binding.remove.setOnClickListener(v -> startFragment(Action.REMOVE, binding.backStackCheckbox.isChecked(), Objects.requireNonNull(binding.colorText.getText()).toString()));
        binding.popBackstack.setOnClickListener(v -> startFragment(Action.POP, binding.backStackCheckbox.isChecked(), Objects.requireNonNull(binding.colorText.getText()).toString()));

        binding.bottomNavigation.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.home) {
                startFragment(Action.ADD, false, "#000000");
            } else if (id == R.id.list) {
                startFragment(Action.ADD, false, "#fcba03");
            } else if (id == R.id.account) {
                startFragment(Action.ADD, false, "#1dadf5");
            }
            return false;
        });
    }

    private void startFragment(Action action, Boolean addToBackStack, String color) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = ExampleFragment.newInstance(color);
        switch (action) {
            case ADD:
                transaction = transaction.add(R.id.fragmentContainer, fragment);
                break;
            case REPLACE:
                transaction = transaction.replace(R.id.fragmentContainer, fragment);
                break;
            case REMOVE:
                transaction = transaction.remove(fragment);
                break;
            case POP:
                getSupportFragmentManager().popBackStack();
                break;
        }
        if (addToBackStack) {
            transaction = transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
