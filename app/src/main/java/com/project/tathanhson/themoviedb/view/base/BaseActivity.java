package com.project.tathanhson.themoviedb.view.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public abstract class BaseActivity<V extends ViewBinding, VM extends BaseViewModel>
        extends FragmentActivity
        implements ItfView<V, VM> {
    protected V binding;
    protected VM model;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        model = new ViewModelProvider(this).get(initViewModelClass());
        setContentView(binding.getRoot());
        initViews();
    }
}

