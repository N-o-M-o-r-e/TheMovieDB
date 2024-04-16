package com.project.tathanhson.themoviedb.view.fragment;

import static com.project.tathanhson.themoviedb.view.adapter.MoviesAdapter.PATH_IMAGE;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.databinding.FragmentMovieDetailBinding;
import com.project.tathanhson.themoviedb.model.api.res.DetailMoviesRes;
import com.project.tathanhson.themoviedb.model.api.res.MovieRes;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.MovieDetailVM;

public class MovieDetailFragment extends BaseFragment<FragmentMovieDetailBinding, MovieDetailVM> {
    public static final String TAG = MovieDetailFragment.class.getName();
    private String mgenres ="";

    @Nullable
    @Override
    public Class<MovieDetailVM> initViewModelClass() {
        return MovieDetailVM.class;
    }

    @Nullable
    @Override
    public FragmentMovieDetailBinding initViewBinding() {
        return FragmentMovieDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    public void initViews() {
        MovieRes.Results item = (MovieRes.Results) data;
        if (item == null){
            Toast.makeText(context, "data null", Toast.LENGTH_SHORT).show();
            return;
        }
        viewModel.getMovieDetail(item.id);
    }

    @SuppressLint("LogConditional")
    @Override
    public void apiSucsess(String key, Object data) {
        DetailMoviesRes res = (DetailMoviesRes) data;
        Log.i("AAAAAAAAA", "apiSucsess: - "
                +res.title+"\n"
                +res.backdropPath+"\n"
                +res.posterPath+"\n"
                +res.releaseDate+"\n"
                +res.overview+"\n"
                +res.runtime);
        setDataToView(res);
    }

    private void setDataToView(DetailMoviesRes res) {
        String dateStr = res.releaseDate; // Chuỗi ngày tháng dạng "2024-03-02"
        String year = dateStr.substring(0, 4);// Cắt chuỗi để lấy phần năm

        for (int i = 0; i < res.genres.size() ; i++) {
            mgenres = res.genres.get(i).name+", ";
        }

        Glide.with(context).load(String.format(PATH_IMAGE, res.backdropPath)).into(binding.ivBackdrop);
        Glide.with(context).load(String.format(PATH_IMAGE, res.posterPath)).into(binding.ivAvatar);
        binding.tvTitle.setText(res.title);
        binding.tvYear.setText(year);
        binding.tvUserScore.setText(res.voteAverage*10+"%");
        binding.tvTime.setText(res.runtime+"");
        binding.tvGenres.setText(mgenres);
        binding.tvOverview.setText(res.overview);





    }
}