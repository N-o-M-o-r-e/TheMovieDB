package com.project.tathanhson.themoviedb.view.activity;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.ActivityMainBinding;
import com.project.tathanhson.themoviedb.view.base.BaseActivity;
import com.project.tathanhson.themoviedb.view.base.OnMainCallback;
import com.project.tathanhson.themoviedb.view.fragment.LoginFragment;
import com.project.tathanhson.themoviedb.view.fragment.SplashFragment;
import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> implements OnMainCallback {
    private SplashFragment frgSplash;
    private LoginFragment frgLogin;

    @Override
    public Class<BaseViewModel> initViewModelClass() {
        return BaseViewModel.class;
    }

    @Override
    public ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initViews() {
        frgSplash = new SplashFragment();
        frgSplash.setCallBack(this);
        frgLogin = new LoginFragment();
        frgLogin.setCallBack(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, frgSplash)
                .commit();
    }

    @Override
    public void showFragment(String tag, Object data) {
        if (tag.equals(LoginFragment.TAG)) {
            showFragmentLogin(data);
        }
    }

    private void showFragmentLogin(Object data) {
        frgLogin.setData(data);
        frgLogin.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, frgLogin).addToBackStack(null).commit();
    }


}
