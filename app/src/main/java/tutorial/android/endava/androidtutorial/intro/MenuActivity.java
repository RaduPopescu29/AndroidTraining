package tutorial.android.endava.androidtutorial.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import tutorial.android.endava.androidtutorial.R;
import tutorial.android.endava.androidtutorial.chapter_activties.ActivitiesActivity;
import tutorial.android.endava.androidtutorial.chapter_list.TouristTrapActivity;
import tutorial.android.endava.androidtutorial.chapter_list.PlacesToSeeActivity;
import tutorial.android.endava.androidtutorial.chapter_photography.PhotographyActivity;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class MenuActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<String> menuList = new ArrayList<>();
        menuList.add(getString(R.string.second_chapter_text));
        menuList.add(getString(R.string.third_chapter_text));
        menuList.add(getString(R.string.fourth_chapter_text));
        menuList.add(getString(R.string.fifth_chapter_text));
        menuList.add(getString(R.string.sixth_chapter_text));
        menuList.add(getString(R.string.seventh_chapter_text));
        menuList.add(getString(R.string.eighth_chapter_text));
        menuList.add(getString(R.string.ninth_chapter_text));
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view_menu);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MenuAdapter(menuList));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent activityChapterIntent = new Intent(getContext(), ActivitiesActivity.class);
                        startActivity(activityChapterIntent);
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent goodListChapterIntent = new Intent(getContext(), PlacesToSeeActivity.class);
                        startActivity(goodListChapterIntent);
                        break;
                    case 3:
                        Intent badListChapterIntent = new Intent(getContext(), TouristTrapActivity.class);
                        startActivity(badListChapterIntent);
                        break;
                    case 5:
                        Intent photographyIntent = new Intent(getContext(), PhotographyActivity.class);
                        startActivity(photographyIntent);
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));
    }

    private Context getContext() {
        return this;
    }


}
