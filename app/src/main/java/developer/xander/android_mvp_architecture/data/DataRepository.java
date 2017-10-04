package developer.xander.android_mvp_architecture.data;


import java.util.List;

import developer.xander.android_mvp_architecture.data.local.DbHelper;
import developer.xander.android_mvp_architecture.data.model.Feed.FeedRequest;
import developer.xander.android_mvp_architecture.data.model.SampleModel;
import developer.xander.android_mvp_architecture.data.prefs.PreferenceHelper;
import developer.xander.android_mvp_architecture.data.remote.APIError;
import developer.xander.android_mvp_architecture.data.remote.ApiHelper;

/**
 * Created by Augtonov on 2/10/17.
 */

public class DataRepository implements DataManager{
    private static DataRepository ourInstance;

    private PreferenceHelper preferencesHelper;
    private DbHelper dbHelper;
    private ApiHelper apiHelper;

    public static synchronized DataRepository getInstance(ApiHelper apiHelper, DbHelper dbHelper,
                                             PreferenceHelper preferencesHelper) {

        //TODO pass apihelper class also in argument

        if (ourInstance == null) {
            ourInstance = new DataRepository(apiHelper, dbHelper, preferencesHelper);
        }

        return ourInstance;
    }

    private DataRepository(ApiHelper apiHelper, DbHelper dbHelper,
                           PreferenceHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
        this.dbHelper = dbHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public String getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(String userId) {
        preferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public void deleteCurrentUserId() {
        preferencesHelper.deleteCurrentUserId();
    }

    @Override
    public void getFeed(FeedRequest feedRequest, final ResponseCallback responseCallback) {
        if (feedRequest.isCached()) {
            //TODO get data from cache
            dbHelper.getFeed(feedRequest, new ResponseCallback<List<SampleModel>>() {
                @Override
                public void onSuccess(List<SampleModel> sampleModels) throws Exception {
                    responseCallback.onSuccess(sampleModels);
                }

                @Override
                public void onError(APIError apiError) {
                    //TODO no data found
                }
            });
        }else {
            apiHelper.getFeed(feedRequest, responseCallback);
        }

    }
}
