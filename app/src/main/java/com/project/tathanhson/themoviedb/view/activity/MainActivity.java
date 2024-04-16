package com.project.tathanhson.themoviedb.view.activity;

import androidx.annotation.Nullable;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.ActivityMainBinding;
import com.project.tathanhson.themoviedb.view.base.BaseActivity;
import com.project.tathanhson.themoviedb.view.base.OnMainCallback;
import com.project.tathanhson.themoviedb.view.fragment.MovieDetailFragment;
import com.project.tathanhson.themoviedb.view.fragment.MovieListFragment;
import com.project.tathanhson.themoviedb.view.fragment.LoginFragment;
import com.project.tathanhson.themoviedb.view.fragment.SplashFragment;
import com.project.tathanhson.themoviedb.viewmodel.BaseViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> implements OnMainCallback {
    private SplashFragment frgSplash;
    private LoginFragment frgLogin;
    private MovieListFragment frgListMovies;

    private MovieDetailFragment frgDetailFragment;

    @Nullable
    @Override
    public Class<BaseViewModel> initViewModelClass() {
        return BaseViewModel.class;
    }

    @Nullable
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
        frgListMovies = new MovieListFragment();
        frgListMovies.setCallBack(this);
        frgDetailFragment = new MovieDetailFragment();
        frgDetailFragment.setCallBack(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, frgSplash)
                .commit();
    }

    @Override
    public void showFragment(@Nullable String tag, @Nullable Object data) {
        if (tag.equals(LoginFragment.TAG)) {
            showFragmentLogin(data);
        }
        if (tag.equals(MovieListFragment.TAG)) {
            showFragmentListMovies(data);
        }
        if (tag.equals(MovieDetailFragment.TAG)){
            showFragmemtDetailMovies(data);
        }
    }

    private void showFragmemtDetailMovies(Object data) {
        frgDetailFragment.setData(data);
        frgDetailFragment.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, frgDetailFragment).addToBackStack(null).commit();

    }

    private void showFragmentLogin(Object data) {
        frgLogin.setData(data);
        frgLogin.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, frgLogin).addToBackStack(null).commit();
    }

    private void showFragmentListMovies(Object data) {
        frgListMovies.setData(data);
        frgListMovies.setCallBack(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, frgListMovies).addToBackStack(null).commit();
    }




}
