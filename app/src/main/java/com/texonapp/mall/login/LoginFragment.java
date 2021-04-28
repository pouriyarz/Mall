package com.texonapp.mall.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.texonapp.mall.R;
import com.texonapp.mall.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    CallbackManager callbackManager;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View mainView = binding.getRoot();
        configureGoogleSingIn(mainView);
        configureFacebookLogin();

        binding.login.setOnClickListener(view -> {
            navController.navigate(R.id.action_loginFragment_to_mainActivity);
            getActivity().finish();
        });

        binding.facebookLoginBut.setOnClickListener(view -> {
            registerSocialAccount();
            //binding.facebookLogin.performClick();
        });

        binding.googleAccount.setOnClickListener(view -> {
            registerSocialAccount();
            //signIn();
        });
        binding.phoneLogin.setOnClickListener(view -> {
            navController.navigate(R.id.action_loginFragment_to_registerFragment);
        });

        binding.resetPassword.setOnClickListener(view -> {
            navController.navigate(R.id.action_loginFragment_to_resetPasswordFragment);
        });
        return mainView;
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void configureFacebookLogin(){
        callbackManager = CallbackManager.Factory.create();
        binding.facebookLogin.setFragment(this);
        handleGoogleFacebookLogin();
    }

    public void handleGoogleFacebookLogin(){
        binding.facebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public void configureGoogleSingIn(View view) {
        String serverClientId = getString(R.string.server_client_id);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestServerAuthCode(serverClientId)
                .requestProfile()
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(view.getContext(), gso);
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            String serverAuthCode = account.getServerAuthCode();

        } catch (ApiException e) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        } else {
            callbackManager.onActivityResult(requestCode, requestCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);

        }
    }

    private void registerSocialAccount() {
        navController.navigate(R.id.action_loginFragment_to_socialAccountRegisterFragment);
    }
}