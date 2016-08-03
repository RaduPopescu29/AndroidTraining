package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardDetailsActivity extends AppCompatActivity {

    private static final int RESULT_CODE_FOR_EDIT = 1;

    TextView mPostcardTextView;
    TextView mDestinationTextView;
    TextView mDateTextView;
    Button mEditBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard_details);

        initViews();
    }

    private void initViews() {
        mPostcardTextView = (TextView) findViewById(R.id.tv_postcard_text);
        mDestinationTextView = (TextView) findViewById(R.id.tv_postcard_destination);
        mDateTextView = (TextView) findViewById(R.id.tv_postcard_date);
        mEditBtn = (Button) findViewById(R.id.btn_edit);

        // make the TextView scrollable
        mPostcardTextView.setMovementMethod(new ScrollingMovementMethod());
        //set the destination and the date of the postcard
        String destination = String.format(getResources().getString(R.string.postcard_details_destination), "Paris");
        mDestinationTextView.setText(destination);
        String date = String.format(getResources().getString(R.string.postcard_details_date), "11/11/2015");
        mDateTextView.setText(date);

        mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goodListChapterIntent = new Intent(PostcardDetailsActivity.this, PostcardEditActivity.class);
                startActivityForResult(goodListChapterIntent, RESULT_CODE_FOR_EDIT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_CODE_FOR_EDIT:
                if (resultCode == RESULT_OK) {
                    PostCard card = (PostCard) data.getExtras().getSerializable(PostcardEditActivity.BUNDLE_POSTCARD_DATA);
                    //set the destination and the date of the postcard
                    String destination = String.format(getResources().getString(R.string.postcard_details_destination), card.getDestination());
                    mDestinationTextView.setText(destination);
                    String date = String.format(getResources().getString(R.string.postcard_details_date), card.getDate());
                    mDateTextView.setText(date);
                    mPostcardTextView.setText(card.getText());
                }
                break;
        }
    }
}
