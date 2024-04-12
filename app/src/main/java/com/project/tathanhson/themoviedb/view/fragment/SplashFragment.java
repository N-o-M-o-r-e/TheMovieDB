package com.project.tathanhson.themoviedb.view.fragment;

import android.os.Handler;

import androidx.annotation.Nullable;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.FragmentSplashBinding;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.LoginViewModel;

public class SplashFragment extends BaseFragment<FragmentSplashBinding, LoginViewModel> {
    public static final String TAG = SplashFragment.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Nullable
    @Override
    public Class<LoginViewModel> initViewModelClass() {
        return LoginViewModel.class;
    }

    @Nullable
    @Override
    public FragmentSplashBinding initViewBinding() {
        return FragmentSplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initViews() {
        new Handler().postDelayed(this::goToLogin, 2000);
    }

    public void goToLogin() {
        callBack.showFragment(LoginFragment.TAG, null);
    }
}