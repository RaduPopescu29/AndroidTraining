package tutorial.android.endava.androidtutorial.chapter_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class BadListActivity extends AppCompatActivity {

    private ListView mListView;
    private BadPersonAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new BadPersonAdapter(this, new ArrayList<Person>());
        mListView.setAdapter(mAdapter);
        populateAdapter();
    }

    private void populateAdapter() {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setName("First Last Name " + i);
            person.setCompanyName("Company Name " + i);
            if (i % 2 == 0) {
                person.setPosition("Software Engineer");
            } else {
                person.setPosition("Junior Technician");
            }
            persons.add(person);
        }
        mAdapter.addAll(persons);
        mAdapter.notifyDataSetChanged();
    }
}