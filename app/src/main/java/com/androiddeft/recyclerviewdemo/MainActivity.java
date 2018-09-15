package com.androiddeft.recyclerviewdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.androiddeft.recyclerviewdemo.beans.Movie;
import com.androiddeft.recyclerviewdemo.font.FontHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Movie> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movies);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        populateMovieDetails();
        mAdapter.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
                recyclerView, new RecyclerItemListener.RecyclerTouchListener() {
            @Override
            public void onClickItem(View v, int position) {
                Toast.makeText(getApplicationContext(), "Clicked: " +
                        movies.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickItem(View v, int position) {
                Toast.makeText(getApplicationContext(), "Long Pressed: " +
                        movies.get(position).getMovieName(), Toast.LENGTH_SHORT).show();

            }
        }));

        recyclerView.addItemDecoration(
                new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.item_seperator)));
    }

    private void populateMovieDetails() {
        movies.add(new Movie("The Shawshank Redemption", "Crime, Drama", 1994, 9.2));
        movies.add(new Movie("The Godfather", "Crime, Drama", 1972, 9.2));
        movies.add(new Movie("The Godfather: Part II", "Crime, Drama", 1974, 9.0));
        movies.add(new Movie("The Dark Knight", "Action, Crime, Drama", 2008, 9.0));
        movies.add(new Movie("12 Angry Men", "Crime, Drama", 1974, 8.9));
        movies.add(new Movie("Schindler's List", "Biography, Drama, History", 1993, 8.9));
        movies.add(new Movie("Pulp Fiction", "Crime, Drama", 1994, 8.9));
        movies.add(new Movie("The Lord of the Rings", "Adventure, Drama, Fantasy", 2003, 8.9));
        movies.add(new Movie("The Good, the Bad and the Ugly", "Western", 1967, 8.9));
        movies.add(new Movie("Fight Club", "Drama", 1999, 8.8));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.font_small:
                FontHelper.scaleFont(MainActivity.this, 0);
                break;
            case R.id.font_big:
                FontHelper.scaleFont(MainActivity.this, 1);

                break;
            case R.id.font_huge:
                FontHelper.scaleFont(MainActivity.this, 2);
                break;
        }
        mAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
}
