package developer.xander.android_mvp_architecture.utilities.permission;

/**
 * Created by anu on 16/11/16.
 */

public interface SmartCallback {

    /**
     * @param allPermissionsGranted true if all permissions are granted
     * @param somePermissionsDeniedForever true if one of asked permissions are denied forever
     */
    void result(boolean allPermissionsGranted, boolean somePermissionsDeniedForever);

}
