package com.project.tathanhson.themoviedb.view.base;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public interface ItfView<V extends ViewBinding, VM extends BaseViewModel> {

    @Nullable
    Class<VM> initViewModelClass();

    V initViewBinding();

    void initViews();
}
