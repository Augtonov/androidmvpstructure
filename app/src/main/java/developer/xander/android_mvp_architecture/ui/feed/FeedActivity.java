package developer.xander.android_mvp_architecture.ui.feed;

import android.os.Bundle;

import developer.xander.android_mvp_architecture.R;
import developer.xander.android_mvp_architecture.data.DataRepository;
import developer.xander.android_mvp_architecture.data.local.DbManager;
import developer.xander.android_mvp_architecture.data.prefs.PreferenceManager;
import developer.xander.android_mvp_architecture.data.remote.ApiManger;
import developer.xander.android_mvp_architecture.ui.base.BaseActivity;

public class FeedActivity extends BaseActivity implements FeedContract.View{

    private FeedContract.Presenter mFeedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mFeedPresenter = new FeedPresenter(DataRepository.getInstance(ApiManger.getInstance(),
                DbManager.getInstance(this), PreferenceManager.getInstance()), this);

    }

    @Override
    public void setFeed() {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }
}
