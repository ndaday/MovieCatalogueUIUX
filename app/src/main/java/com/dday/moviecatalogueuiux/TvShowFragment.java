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
public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ArrayList<TvShow> list = new ArrayList<>();
    private View fView;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fView = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvTvShow = fView.findViewById(R.id.rv_movies);
        rvTvShow.setHasFixedSize(true);

        list.addAll(getListTvShow());
        showRecyclerList();
        return fView;
    }

    public ArrayList<TvShow> getListTvShow() {
        String[] tvshow_title = getResources().getStringArray(R.array.tvshow_title);
        String[] tvshow_releasedate = getResources().getStringArray(R.array.tvshow_releasedate);
        String[] tvshow_rating = getResources().getStringArray(R.array.tvshow_rating);
        String[] tvshow_overview = getResources().getStringArray(R.array.tvshow_overview);
        TypedArray tvshow_poster = getResources().obtainTypedArray(R.array.tvshow_poster);

        ArrayList<TvShow> listTvShow = new ArrayList<>();
        for (int i = 0; i < tvshow_title.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setTitleTvShow(tvshow_title[i]);
            tvShow.setReleaseTvShow(tvshow_releasedate[i]);
            tvShow.setRatingTvShow(tvshow_rating[i]);
            tvShow.setOverviewTvShow(tvshow_overview[i]);
            tvShow.setPoster(tvshow_poster.getResourceId(i, -1));
            listTvShow.add(tvShow);
        }
        return listTvShow;
    }

    private void showRecyclerList() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ListTvShowsAdapter listTvShowsAdapter = new ListTvShowsAdapter(list);
        rvTvShow.setAdapter(listTvShowsAdapter);
        listTvShowsAdapter.setOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), DetailTvShow.class);
                TvShow clickedtvshow = list.get(position);
                intent.putExtra("Detail", clickedtvshow);
                startActivity(intent);
            }
        });
    }

}
