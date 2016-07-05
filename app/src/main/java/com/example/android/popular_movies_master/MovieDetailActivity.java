package com.example.android.popular_movies_master;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // Show the Up button in the action bar.
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(MovieDetailActivityFragment.ID_KEY,
                    getIntent().getIntExtra(MovieDetailActivityFragment.ID_KEY,0));
            arguments.putString(MovieDetailActivityFragment.TITLE_KEY,
                    getIntent().getStringExtra(MovieDetailActivityFragment.TITLE_KEY));
            arguments.putString(MovieDetailActivityFragment.POSTER_KEY,
                    getIntent().getStringExtra(MovieDetailActivityFragment.POSTER_KEY));
            arguments.putString(MovieDetailActivityFragment.OVERVIEW_KEY,
                    getIntent().getStringExtra(MovieDetailActivityFragment.OVERVIEW_KEY));
            arguments.putString(MovieDetailActivityFragment.RELEASE_DATE_KEY,
                    getIntent().getStringExtra(MovieDetailActivityFragment.RELEASE_DATE_KEY));
            arguments.putString(MovieDetailActivityFragment.VOTES_KEY,
                    getIntent().getStringExtra(MovieDetailActivityFragment.VOTES_KEY));

            MovieDetailActivityFragment fragment = new MovieDetailActivityFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();


        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, MovieListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
