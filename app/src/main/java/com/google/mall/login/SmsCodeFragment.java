package com.google.mall.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.mall.R;

public class SmsCodeFragment extends Fragment {

    public static SmsCodeFragment newInstance() {
        SmsCodeFragment fragment = new SmsCodeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sms_code, container, false);
    }
}