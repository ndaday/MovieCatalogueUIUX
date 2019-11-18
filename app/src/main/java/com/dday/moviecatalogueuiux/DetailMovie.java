package com.dday.moviecatalogueuiux;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {
    Movie movie;
    String title, overview, releasedate, rating;
    int poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        ImageView imageView = findViewById(R.id.image_view_Poster);
        TextView tvjudul = findViewById(R.id.text_view_Judul);
        TextView tvsinopsis = findViewById(R.id.text_view_Sinopsis);
        TextView tvrilis = findViewById(R.id.textView_Rilis);
        TextView tvrating = findViewById(R.id.textView_Rating);


        movie = getIntent().getParcelableExtra("Detail");
        title = movie.getTitleMovie();
        overview = movie.getOverviewMovie();
        releasedate = movie.getReleaseMovie();
        rating = movie.getRatingMovie();
        poster = movie.getPoster();

        Glide.with(this).load(poster).centerInside().into(imageView);
        tvjudul.setText(title);
        tvsinopsis.setText(overview);
        tvrilis.setText(releasedate);
        tvrating.setText(rating);

    }
}
