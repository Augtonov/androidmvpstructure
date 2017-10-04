package developer.xander.android_mvp_architecture.data;


import developer.xander.android_mvp_architecture.data.model.Feed.FeedRequest;

/**
 * Created by tony on 3/10/17.
 */

public interface BaseDataService {

    void getFeed(FeedRequest feedRequest, ResponseCallback responseCallback);
}
