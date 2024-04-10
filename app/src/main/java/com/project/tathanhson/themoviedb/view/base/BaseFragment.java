package com.project.tathanhson.themoviedb.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public abstract class BaseFragment<V extends ViewBinding, VM extends BaseViewModel> extends Fragment implements ItfView<V, VM> {
    protected V binding;
    protected VM viewModel;

    protected OnMainCallback callBack;
    protected Object data;
    protected Context context;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(getLayoutId(), container, false);
        binding = initViewBinding();
        viewModel = new ViewModelProvider(this).get(initViewModelClass());
        return binding.getRoot();
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    public OnMainCallback getCallBack() {
        return callBack;
    }

    public void setCallBack(OnMainCallback callBack) {
        this.callBack = callBack;
    }
}