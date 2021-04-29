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
import com.texonapp.mall.databinding.FragmentLoginBinding;
import com.texonapp.mall.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    NavController navController;

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        View mainView = binding.getRoot();

        binding.next.setOnClickListener(view -> {
            navController.navigate(R.id.action_registerFragment_to_smsCodeFragment);
        });
        binding.backToLogin.setOnClickListener(view -> {
            navController.navigate(R.id.action_registerFragment_to_loginFragment);
        });
        return mainView;
    }
}