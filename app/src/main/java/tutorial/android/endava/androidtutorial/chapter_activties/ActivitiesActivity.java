package tutorial.android.endava.androidtutorial.chapter_activties;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class ActivitiesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ActivitiesActivity.class.getSimpleName();
    private TextView mCreateTitleView;
    private TextView mCreateDescriptionView;
    private TextView mStartTitleView;
    private TextView mStartDescriptionView;
    private TextView mResumeTitleView;
    private TextView mResumeDescriptionView;
    private TextView mPauseTitleView;
    private TextView mPauseDescriptionView;
    private TextView mStopTitleView;
    private TextView mStopDescriptionView;
    private ImageView mTopImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        initViews();
        showLogs("onCreate");
        mCreateDescriptionView.setVisibility(View.VISIBLE);
        mCreateTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLogs("onStart");
        mStartDescriptionView.setVisibility(View.VISIBLE);
        mStartTitleView.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showLogs("onResume");
        mResumeDescriptionView.setVisibility(View.VISIBLE);
        mResumeTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLogs("onPause");
        showToast(getString(R.string.pause_activity_toast));
        mPauseDescriptionView.setVisibility(View.VISIBLE);
        mPauseTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLogs("onStop");
        mStopTitleView.setVisibility(View.VISIBLE);
        mStopDescriptionView.setVisibility(View.VISIBLE);
        showToast(getString(R.string.stop_activity_toast));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLogs("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLogs("onRestart");
    }

    private void showLogs(String action) {
        Log.i(TAG, action);
    }

    private void initViews() {
        mCreateTitleView = (TextView) findViewById(R.id.create_title_view);
        mCreateDescriptionView = (TextView) findViewById(R.id.create_description_view);
        mStartTitleView = (TextView) findViewById(R.id.start_title_view);
        mStartDescriptionView = (TextView) findViewById(R.id.start_description_view);
        mResumeTitleView = (TextView) findViewById(R.id.resume_title_view);
        mResumeDescriptionView = (TextView) findViewById(R.id.resume_description_view);
        mPauseTitleView = (TextView) findViewById(R.id.pause_title_view);
        mPauseDescriptionView = (TextView) findViewById(R.id.pause_description_view);
        mStopTitleView = (TextView) findViewById(R.id.stop_title_view);
        mStopDescriptionView = (TextView) findViewById(R.id.stop_description_view);
        findViewById(R.id.pause_activity_button).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pause_activity_button:
                startPauseActivity();
                break;
        }
    }

    private void startPauseActivity() {
        Intent intent = new Intent(this, PauseActivity.class);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
