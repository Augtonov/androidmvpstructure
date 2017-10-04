package developer.xander.android_mvp_architecture.ui.base;

/**
 * Created by Augtonov on 2/10/17.
 */

public abstract class BaseRequest {

    private boolean isCached = false;
    private int cachingTime = 0;

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean cached) {
        isCached = cached;
    }

    public int getCachingTime() {
        return cachingTime;
    }

    public void setCachingTime(int cachingTime) {
        this.cachingTime = cachingTime;
    }
}
