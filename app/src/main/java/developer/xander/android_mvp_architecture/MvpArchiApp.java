package developer.xander.android_mvp_architecture;

import android.app.Application;

import developer.xander.android_mvp_architecture.utilities.AppLogger;


/**
 * Created by Augtonov on 1/10/17.
 */

public class MvpArchiApp extends Application {
    private static MvpArchiApp context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        AppLogger.init();
    }

    public static MvpArchiApp getContext() {
        return context;
    }
}
