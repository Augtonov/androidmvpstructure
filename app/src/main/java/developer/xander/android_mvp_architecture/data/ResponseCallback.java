package developer.xander.android_mvp_architecture.data;


import developer.xander.android_mvp_architecture.utilities.AppLogger;

/**
 * Created by Augtonov on 2/10/17.
 */

public abstract class ResponseCallback<T> implements BaseResponseCallback<T>{
    private final String TAG = "response_callback";

    @Override
    public void onNetworkNotAvailable() {
        AppLogger.d(TAG, "No Network");

    }

    @Override
    public void onDataNotAvailable() {
        AppLogger.d(TAG, "No Data Available");
    }
}
