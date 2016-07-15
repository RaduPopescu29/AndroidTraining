package tutorial.android.endava.androidtutorial.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import tutorial.android.endava.androidtutorial.R;
import tutorial.android.endava.androidtutorial.chapter_activties.ActivitiesActivity;
import tutorial.android.endava.androidtutorial.chapter_list.BadListActivity;
import tutorial.android.endava.androidtutorial.chapter_list.ListActivity;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViewById(R.id.first_chapter_button).setOnClickListener(this);
        findViewById(R.id.second_chapter_button).setOnClickListener(this);
        findViewById(R.id.third_chapter_button).setOnClickListener(this);
        findViewById(R.id.fourth_chapter_button).setOnClickListener(this);
        findViewById(R.id.fifth_chapter_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_chapter_button:
                break;
            case R.id.second_chapter_button:
                Intent activityChapterIntent = new Intent(this, ActivitiesActivity.class);
                startActivity(activityChapterIntent);
                break;
            case R.id.third_chapter_button:
                break;
            case R.id.fourth_chapter_button:
                Intent goodListChapterIntent = new Intent(this, ListActivity.class);
                startActivity(goodListChapterIntent);
                break;
            case R.id.fifth_chapter_button:
                Intent badListChapterIntent = new Intent(this, BadListActivity.class);
                startActivity(badListChapterIntent);
                break;
        }
    }
}
