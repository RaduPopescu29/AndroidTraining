package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard_details);

        TextView postcardTextView = (TextView) findViewById(R.id.tv_postcard_text);
        TextView destinationTextView = (TextView) findViewById(R.id.tv_postcard_destination);
        TextView dateTextView = (TextView) findViewById(R.id.tv_postcard_date);

        // make the textview scrollable
        postcardTextView.setMovementMethod(new ScrollingMovementMethod());
        //set the destination and the date of the postcard
        String destination = String.format(getResources().getString(R.string.postcard_details_destination), "Paris");
        destinationTextView.setText(destination);
        String date = String.format(getResources().getString(R.string.postcard_details_date), "11/11/2015");
        dateTextView.setText(date);

    }
}
