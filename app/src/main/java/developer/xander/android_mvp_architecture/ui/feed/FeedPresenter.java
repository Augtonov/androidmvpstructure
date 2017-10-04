package developer.xander.android_mvp_architecture.ui.feed;

import android.os.Bundle;

import java.util.List;

import developer.xander.android_mvp_architecture.data.DataRepository;
import developer.xander.android_mvp_architecture.data.ResponseCallback;
import developer.xander.android_mvp_architecture.data.model.Feed.FeedRequest;
import developer.xander.android_mvp_architecture.data.model.SampleModel;
import developer.xander.android_mvp_architecture.data.remote.APIError;

/**
 * Created by Augtonov on 2/10/17.
 */

public class FeedPresenter implements FeedContract.Presenter {

    private DataRepository mDataRepository;
    private FeedContract.View mView;

    public FeedPresenter(DataRepository dataRepository, FeedContract.View view) {
        this.mDataRepository = dataRepository;
        this.mView = view;
    }

    @Override
    public void start(Bundle extras) {

    }

    @Override
    public void getFeed() {
        FeedRequest feedRequest = new FeedRequest();
        feedRequest.setCached(true);

        mDataRepository.getFeed(feedRequest, new ResponseCallback<List<SampleModel>>() {
            @Override
            public void onSuccess(List<SampleModel> sampleModels) throws Exception {

            }

            @Override
            public void onError(APIError apiError) {

            }
        });
    }
}
