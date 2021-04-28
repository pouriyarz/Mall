package com.texonapp.mall.login;

import android.os.Bundle;

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
import com.texonapp.mall.databinding.FragmentSocialAccountRegisterBinding;

public class SmsCodeFragment extends Fragment {

    FragmentSmsCodeBinding binding;
    NavController navController;

    public static SmsCodeFragment newInstance() {
        SmsCodeFragment fragment = new SmsCodeFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sms_code, container, false);
        View mainView = binding.getRoot();
        binding.backToLogin.setOnClickListener(view -> {
            navController.navigate(R.id.action_socialAccountRegisterFragment_to_loginFragment);
        });
        binding.next.setOnClickListener(view -> {
            navController.navigate(R.id.action_smsCodeFragment_to_welcomeFragment);
        });

        return mainView;
    }
}