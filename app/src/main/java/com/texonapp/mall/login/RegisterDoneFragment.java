package com.texonapp.mall.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.texonapp.R;

public class RegisterDoneFragment extends Fragment {


    public static RegisterDoneFragment newInstance() {
        RegisterDoneFragment fragment = new RegisterDoneFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_done, container, false);
    }
}