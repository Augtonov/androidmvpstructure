package developer.xander.android_mvp_architecture.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import developer.xander.android_mvp_architecture.MvpArchiApp;


public class NetworkHelper {
 
    private static NetworkHelper networkHelper;
 
    public static synchronized NetworkHelper getInstance() { 
        if (networkHelper == null) {
            networkHelper = new NetworkHelper();
        } 
        return networkHelper;
    } 
 
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) MvpArchiApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
 
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    } 
} 