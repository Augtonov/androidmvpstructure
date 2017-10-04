package developer.xander.android_mvp_architecture.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;


/**
 * Created by tony on 12/21/2015.
 */
public class CommonUtils {

    private static CommonUtils instance;

    public static CommonUtils getUtils() {

        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getTimeWithExtraMin() {
        return System.currentTimeMillis()+minInMilliSeconds(10);
    }

    public long minInMilliSeconds(int min) {
        return (long) (min*60*1000);
    }

    public void shareData(Context context, String data, String subject) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.putExtra(Intent.EXTRA_TEXT, data);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    public void openWebPage(Context context, String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public void openDialPad(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number));
        context.startActivity(intent);

    }

    public String getVersionName(Context context) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        assert pInfo != null;
        return pInfo.versionName;
    }

    public boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
