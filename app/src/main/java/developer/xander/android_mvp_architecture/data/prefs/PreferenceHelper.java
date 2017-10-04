package developer.xander.android_mvp_architecture.data.prefs;

/**
 * Created by Augtonov on 1/10/17.
 */

public interface PreferenceHelper {

    String getCurrentUserId();

    void setCurrentUserId(String userId);

    void deleteCurrentUserId();
}
