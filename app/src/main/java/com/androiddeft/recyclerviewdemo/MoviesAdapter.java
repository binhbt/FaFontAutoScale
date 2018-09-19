package com.androiddeft.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androiddeft.recyclerviewdemo.beans.Movie;
import com.leo.font.lib.annotations.AutoScale;
import com.leo.font.lib.binder.FontBinding;
import com.vn.fa.font.FontManager;

import java.util.List;

/**
 * Created by Abhi on 23 Sep 2017 023.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.CustomViewHolder> {

    private List<Movie> movies;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;
        TextView year;
        public TextView genre;
        public TextView rating;
        @AutoScale
        View root;
        public CustomViewHolder(View view) {
            super(view);
            root = view.findViewById(R.id.rl_root);
            movieName = (TextView) view.findViewById(R.id.movieName);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            rating = (TextView) view.findViewById(R.id.rating);
        }
        public void onBindViewData(Movie movie){
            FontBinding.bind(this);
            movieName.setText(movie.getMovieName());
            genre.setText(movie.getGenre());
            year.setText(String.valueOf(movie.getYear()));
            rating.setText(String.valueOf(movie.getRating()));
        }

    }

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.onBindViewData(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
