package developer.xander.android_mvp_architecture.data.remote;


import java.util.List;

import developer.xander.android_mvp_architecture.data.ResponseCallback;
import developer.xander.android_mvp_architecture.data.model.Feed.FeedRequest;
import developer.xander.android_mvp_architecture.data.model.SampleModel;
import developer.xander.android_mvp_architecture.utilities.NetworkHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Augtonov on 2/10/17.
 */

public class ApiManger implements ApiHelper{

    private static ApiManger ourInstance;
    private ApiService apiService;

    public static ApiManger getInstance() {

        if (ourInstance == null) {
            ourInstance = new ApiManger();
        }
        return ourInstance;
    }

    private ApiManger() {
        apiService = ServiceGenerator.createService(ApiService.class);
    }

    @Override
    public void getFeed(FeedRequest feedRequest, ResponseCallback responseCallback) {

        //TODO retrofit api call

        Call<List<SampleModel>> call = apiService.getFeed();
        sendRequest(call, responseCallback);
    }

    public <T> void sendRequest(Call call, final ResponseCallback responseCallback) {

        if (NetworkHelper.getInstance().isNetworkAvailable()) {
            try {
                call.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {

                        try {
                            if (response.isSuccessful()) {
                                responseCallback.onSuccess(response.body());
                            }else if (response.code() == 204 || response.code() == 404){
                                responseCallback.onDataNotAvailable();
                            }else {
                                APIError error = ErrorUtils.parseError(response);
                                responseCallback.onError(error);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            responseCallback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        APIError apiError = new APIError();
                        apiError.setErrorMsg(t.getMessage());
                        responseCallback.onError(apiError);
                    }
                });
            }catch (Exception e){
                e.printStackTrace();

            }
        }else {
            responseCallback.onNetworkNotAvailable();
        }


    }

}
