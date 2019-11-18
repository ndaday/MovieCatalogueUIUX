package com.dday.moviecatalogueuiux;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();
    private View fView;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fView = inflater.inflate(R.layout.fragment_movies, container, false);

        rvMovies = fView.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListMovie());
        showRecyclerList();
        return fView;
    }

    public ArrayList<Movie> getListMovie() {
        String[] movie_title = getResources().getStringArray(R.array.movie_title);
        String[] movie_releasedate = getResources().getStringArray(R.array.movie_releasedate);
        String[] movie_rating = getResources().getStringArray(R.array.movie_rating);
        String[] movie_overview = getResources().getStringArray(R.array.movie_overview);
        TypedArray movie_poster = getResources().obtainTypedArray(R.array.movie_poster);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < movie_title.length; i++) {
            Movie movie = new Movie();
            movie.setTitleMovie(movie_title[i]);
            movie.setReleaseMovie(movie_releasedate[i]);
            movie.setRatingMovie(movie_rating[i]);
            movie.setOverviewMovie(movie_overview[i]);
            movie.setPoster(movie_poster.getResourceId(i, -1));
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        rvMovies.setAdapter(listMovieAdapter);
        listMovieAdapter.setOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), DetailMovie.class);
                Movie clickedmovie = list.get(position);
                intent.putExtra("Detail", clickedmovie);
                startActivity(intent);
            }
        });
    }

}
