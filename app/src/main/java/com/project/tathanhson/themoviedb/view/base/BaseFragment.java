package com.project.tathanhson.themoviedb.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.project.tathanhson.themoviedb.OnAPICallback;
import com.project.tathanhson.themoviedb.view.fragment.LoginFragment;
import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public abstract class BaseFragment<V extends ViewBinding, VM extends BaseViewModel> extends Fragment implements ItfView<V, VM>, OnAPICallback {
    protected V binding;
    protected VM viewModel;

    @Nullable
    protected OnMainCallback callBack;
    @Nullable
    protected Object data;
    @Nullable
    protected Context context;

    @Nullable
    public Object getData() {
        return data;
    }

    public void setData(@Nullable Object data) {
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
        viewModel.setCallback(this);
        return binding.getRoot();
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Nullable
    public OnMainCallback getCallBack() {
        return callBack;
    }

    public void setCallBack(@Nullable OnMainCallback callBack) {
        this.callBack = callBack;
    }

    @Override
    public void apiSucsess(String key, Object data) {
        //do it
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if (code == 401){
            callBack.showFragment(LoginFragment.TAG, null);
            Toast.makeText(context, "Phiên đăng nhập đã hết hạn", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Error"+code, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public Class<VM> initViewModelClass() {
        return null;
    }

    @Override
    public V initViewBinding() {
        return null;
    }

    @Override
    public void initViews() {

    }
}