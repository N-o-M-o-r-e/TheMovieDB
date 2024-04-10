package com.project.tathanhson.themoviedb.view.fragment;

import android.os.Handler;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.FragmentSplashBinding;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.MainViewModel;

public class SplashFragment extends BaseFragment<FragmentSplashBinding, MainViewModel> {
    public static final String TAG = SplashFragment.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public Class<MainViewModel> initViewModelClass() {
        return MainViewModel.class;
    }

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