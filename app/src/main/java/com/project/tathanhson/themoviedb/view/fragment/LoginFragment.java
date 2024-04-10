package com.project.tathanhson.themoviedb.view.fragment;

import android.view.View;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.FragmentLoginBinding;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.MainViewModel;


public class LoginFragment extends BaseFragment<FragmentLoginBinding, MainViewModel> {
    public static final String TAG = LoginFragment.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public Class<MainViewModel> initViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    public FragmentLoginBinding initViewBinding() {
        return FragmentLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initViews() {
        binding.btnLogin.setOnClickListener(view -> viewModel.getAuthen());
    }
}