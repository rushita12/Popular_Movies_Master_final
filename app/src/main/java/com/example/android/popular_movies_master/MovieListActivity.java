package com.example.android.popular_movies_master;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

public class MovieListActivity extends AppCompatActivity  implements MovieListActivityFragment.OnMovieSelectedListener  {

    private static final String LOG_TAG = MovieListActivity.class.getSimpleName();
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
        }


    }

    @Override
    public void onMovieSelected(int position,int id, String title, String poster_path, String overview, String release_date, String votes) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(MovieDetailActivityFragment.ID_KEY, id);
            arguments.putString(MovieDetailActivityFragment.TITLE_KEY, title);
            arguments.putString(MovieDetailActivityFragment.POSTER_KEY, poster_path);
            arguments.putString(MovieDetailActivityFragment.OVERVIEW_KEY, overview);
            arguments.putString(MovieDetailActivityFragment.RELEASE_DATE_KEY, release_date);
            arguments.putString(MovieDetailActivityFragment.VOTES_KEY, votes);


            MovieDetailActivityFragment fragment = new MovieDetailActivityFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode,

            Intent intent = new Intent(getApplicationContext(), MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivityFragment.ID_KEY,id);
            intent.putExtra(MovieDetailActivityFragment.TITLE_KEY, title);
            intent.putExtra(MovieDetailActivityFragment.POSTER_KEY, poster_path);
            intent.putExtra(MovieDetailActivityFragment.OVERVIEW_KEY, overview);
            intent.putExtra(MovieDetailActivityFragment.RELEASE_DATE_KEY, release_date);
            intent.putExtra(MovieDetailActivityFragment.VOTES_KEY, votes);
            startActivity(intent);
        }
    }

    @Override
    public void onFetchFirstMovie(int position, int id, String title, String poster_path, String overview, String release_date, String votes) {
        if(mTwoPane) {
            Log.d(LOG_TAG, "fetch first movie for tablet");
            Bundle arguments = new Bundle();
            arguments.putInt(MovieDetailActivityFragment.ID_KEY, id);
            arguments.putString(MovieDetailActivityFragment.TITLE_KEY, title);
            arguments.putString(MovieDetailActivityFragment.POSTER_KEY, poster_path);
            arguments.putString(MovieDetailActivityFragment.OVERVIEW_KEY, overview);
            arguments.putString(MovieDetailActivityFragment.RELEASE_DATE_KEY, release_date);
            arguments.putString(MovieDetailActivityFragment.VOTES_KEY, votes);


            MovieDetailActivityFragment fragment = new MovieDetailActivityFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment)
                    .commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return true;
    }


}
