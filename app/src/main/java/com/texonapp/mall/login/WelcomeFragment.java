package com.texonapp.mall.login;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.texonapp.mall.R;
import com.texonapp.mall.databinding.FragmentSmsCodeBinding;
import com.texonapp.mall.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    FragmentWelcomeBinding binding;
    NavController navController;

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        View mainView = binding.getRoot();

        binding.next.setOnClickListener(view -> {
            navController.navigate(R.id.action_welcomeFragment_to_mainActivity);
            getActivity().finish();
        });

        return mainView;
    }
}