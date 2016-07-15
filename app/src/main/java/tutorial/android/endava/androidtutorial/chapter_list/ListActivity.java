package tutorial.android.endava.androidtutorial.chapter_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class ListActivity extends AppCompatActivity {

    private ListView mListView;
    private PersonAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new PersonAdapter(this, new ArrayList<Person>());
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
        //adds the list to the adapter and notifies it in order for the list to be redrawn(only
        // if the mNotifyOnChange boolean from the adapter is set to true, which is, by default).
        // If the mNotifyOnChange is false you will have to call notifyDataSetChanged()l
        mAdapter.addAll(persons);
        //mAdapter.notifyDataSetChanged();
    }

}
