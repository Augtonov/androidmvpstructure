package developer.xander.android_mvp_architecture.data.remote;


import java.util.List;

import developer.xander.android_mvp_architecture.Urls;
import developer.xander.android_mvp_architecture.data.model.SampleModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Augtonov on 1/10/17.
 */

public interface ApiService {

    @GET(Urls.FEED_URL)
    Call<List<SampleModel>> getFeed();

}
