package developer.xander.android_mvp_architecture.data;


import developer.xander.android_mvp_architecture.data.local.DbHelper;
import developer.xander.android_mvp_architecture.data.prefs.PreferenceHelper;
import developer.xander.android_mvp_architecture.data.remote.ApiHelper;

/**
 * Created by Augtonov on 1/10/17.
 */

public interface DataManager extends ApiHelper, PreferenceHelper, DbHelper {

}
