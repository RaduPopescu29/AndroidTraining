package tutorial.android.endava.androidtutorial.chapter_layouts;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by amihaescu on 2/8/2016.
 */
public class PostcardEditActivity extends AppCompatActivity {

    public static final String BUNDLE_POSTCARD_DATA = "postcard_data";

    TextView mPostcardTextView;
    TextView mDestinationTextView;
    TextView mDateTextView;
    Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postcard_edit);

        initViews();
    }

    private void initViews() {
        mPostcardTextView = (TextView) findViewById(R.id.et_postcard_text);
        mDestinationTextView = (TextView) findViewById(R.id.et_postcard_destination);
        mDateTextView = (TextView) findViewById(R.id.et_postcard_date);
        mSaveBtn = (Button) findViewById(R.id.btn_save);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        if (mDateTextView.getText().toString().isEmpty() || mDestinationTextView.getText().toString().isEmpty() || mPostcardTextView.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.postcard_validation_message), Toast.LENGTH_LONG).show();
            return;
        }

        PostCard postCard = new PostCard();
        postCard.setDate(mDateTextView.getText().toString());
        postCard.setDestination(mDestinationTextView.getText().toString());
        postCard.setText(mPostcardTextView.getText().toString());

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_POSTCARD_DATA, postCard);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
       *//* showDialog(getApplicationContext(), getString(R.string.postcard_confirmation_message), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // PostcardEditActivity.this.finish();
            }
        });*//*
    }*/

    public static void showDialog(Context context, String message, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setPositiveButton(android.R.string.yes, listener)
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
