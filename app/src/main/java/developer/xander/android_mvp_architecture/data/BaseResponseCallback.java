package developer.xander.android_mvp_architecture.data;


import developer.xander.android_mvp_architecture.data.remote.APIError;

/**
 * Created by tony on 3/10/17.
 */

public interface BaseResponseCallback<T> {

    void onSuccess(T t) throws Exception;

    void onError(APIError apiError);

    void onNetworkNotAvailable();

    void onDataNotAvailable();
}
