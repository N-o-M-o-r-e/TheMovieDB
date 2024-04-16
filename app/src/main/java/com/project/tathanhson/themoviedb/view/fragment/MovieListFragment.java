package com.project.tathanhson.themoviedb.view.fragment;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.FragmentListMovieBinding;
import com.project.tathanhson.themoviedb.model.api.res.MovieRes;
import com.project.tathanhson.themoviedb.view.adapter.MoviesAdapter;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.ListMovieViewModel;

public class MovieListFragment extends BaseFragment<FragmentListMovieBinding, ListMovieViewModel> {
    public static final String TAG = MovieListFragment.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_movie;
    }

    private MoviesAdapter adapter;

    @Nullable
    @Override
    public Class<ListMovieViewModel> initViewModelClass() {
        return ListMovieViewModel.class;
    }

    @Nullable
    @Override
    public FragmentListMovieBinding initViewBinding() {
        return FragmentListMovieBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initViews() {
        viewModel.getMovieList();
        binding.rcvMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    viewModel.getMovieList();
                }
            }
        });
    }

    @SuppressLint("LogConditional")
    @Override
    public void apiSucsess(String key, Object data) {
        MovieRes movieRes = (MovieRes) data;
        if (movieRes == null || movieRes.results == null || movieRes.results.isEmpty()) {
            Toast.makeText(context, "List movies is null", Toast.LENGTH_SHORT).show();
            Log.d("AAAAAAAA", "data = null");
            return;
        }
        Log.d("AAAAAAAA", "data: " + movieRes.results.size());
//            Log.d("AAAAAAAA", "data: " + movieRes.results.get(2).title);
//            Log.d("AAAAAAAA", "data: " + movieRes.results.get(3).title);

        viewModel.addToResultListMovies(movieRes.results);

        binding.include.tvTotal.setText(String.format("Total: %s", viewModel.getResultsList().size()));

        if (adapter == null) {
            adapter = new MoviesAdapter(viewModel.getResultsList(), context);
            adapter.getItemResult().observe(this, this::handleItemRresult);
            binding.rcvMovies.setAdapter(adapter);
        } else {
            adapter.updateListMovies(viewModel.getResultsList());
            adapter = new MoviesAdapter(viewModel.getResultsList(), context);
            adapter.getItemResult().observe(this, this::handleItemRresult);
            binding.rcvMovies.setAdapter(adapter);
        }
    }

    private void handleItemRresult(MovieRes.Results results) {
        if (results == null) return;
        else {
            callBack.showFragment(MovieDetailFragment.TAG, results);
        }
    }
}