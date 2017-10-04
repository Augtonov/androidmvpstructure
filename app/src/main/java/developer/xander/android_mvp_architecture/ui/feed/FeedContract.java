package developer.xander.android_mvp_architecture.ui.feed;


import developer.xander.android_mvp_architecture.ui.base.BasePresenter;
import developer.xander.android_mvp_architecture.ui.base.BaseView;

/**
 * Created by Augtonov on 2/10/17.
 */

public class FeedContract {

    interface View extends BaseView {
        void setFeed();
    }

    interface Presenter extends BasePresenter {

        void getFeed();

    }



}
