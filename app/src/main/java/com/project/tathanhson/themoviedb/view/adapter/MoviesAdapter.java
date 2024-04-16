package com.project.tathanhson.themoviedb.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.tathanhson.themoviedb.databinding.ItemListMoviesBinding;
import com.project.tathanhson.themoviedb.model.api.res.MovieRes;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {
    private  List<MovieRes.Results> listMovies;
    private final Context context;

    private final MutableLiveData<MovieRes.Results>  itemResult = new MutableLiveData<>();

    public static final String PATH_IMAGE ="https://media.themoviedb.org/t/p/w300_and_h450_bestv2/%s";


    public MoviesAdapter(List<MovieRes.Results> listMovies, Context context) {
        this.listMovies = listMovies;
        this.context = context;
    }


    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMoviesBinding binding = ItemListMoviesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MoviesHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position){
        MovieRes.Results item = listMovies.get(position);
        holder.binding.tvTitle.setText(item.title);
        holder.binding.tvDetail.setText(item.overview);
        holder.binding.tvDate.setText(item.releaseDate);

        String linkImage = "https://media.themoviedb.org/t/p/w300_and_h450_bestv2/"+ item.posterPath;
        Glide.with(context).load(String.format(PATH_IMAGE, item.posterPath)).into(holder.binding.ivAvatar);

        holder.binding.tvTitle.setTag(item);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateListMovies(List<MovieRes.Results> resultsList) {
        listMovies = resultsList;
        notifyDataSetChanged();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {
        private final ItemListMoviesBinding binding;
        public MoviesHolder(@NonNull ItemListMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.itemMovies.setOnClickListener(view -> {
                view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
                showDetailMovies(binding.tvTitle.getTag());

            });

        }
    }

    private void showDetailMovies(Object tag) {
        itemResult.setValue((MovieRes.Results) tag);

    }

    public MutableLiveData<MovieRes.Results> getItemResult() {
        return itemResult;
    }
}
