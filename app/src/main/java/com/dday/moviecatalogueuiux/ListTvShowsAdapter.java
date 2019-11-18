package com.dday.moviecatalogueuiux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListTvShowsAdapter extends RecyclerView.Adapter<ListTvShowsAdapter.ListViewHolder> {
    private ArrayList<TvShow> listtvShows;

    public ListTvShowsAdapter(ArrayList<TvShow> list) {
        this.listtvShows = list;
    }

    private ListMovieAdapter.OnItemClickListener cListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(ListMovieAdapter.OnItemClickListener listener) {
        cListener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        TvShow tvShow = listtvShows.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPoster())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPoster);
        holder.txtTitle.setText(tvShow.getTitleTvShow());
        holder.txtReleasedate.setText(tvShow.getReleaseTvShow());
        holder.txtOverview.setText(tvShow.getOverviewTvShow());
        holder.txtRating.setText(tvShow.getRatingTvShow());
    }

    @Override
    public int getItemCount() {
        return listtvShows.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView txtTitle, txtReleasedate, txtRating, txtOverview;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_poster);
            txtTitle = itemView.findViewById(R.id.tv_title);
            txtReleasedate = itemView.findViewById(R.id.tv_releasedate);
            txtOverview = itemView.findViewById(R.id.tv_overview);
            txtRating = itemView.findViewById(R.id.tv_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            cListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
