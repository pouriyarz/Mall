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
import com.texonapp.mall.databinding.FragmentRegisterBinding;
import com.texonapp.mall.databinding.FragmentResetPasswordBinding;

public class ResetPasswordFragment extends Fragment {

    FragmentResetPasswordBinding binding;
    NavController navController;

    public static ResetPasswordFragment newInstance() {
        ResetPasswordFragment fragment = new ResetPasswordFragment();;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reset_password, container, false);
        View mainView = binding.getRoot();
        binding.complete.setOnClickListener(view -> {

        });

        binding.backToLogin.setOnClickListener(view -> {
            navController.navigate(R.id.action_resetPasswordFragment_to_loginFragment);
        });

        return mainView;
    }
}