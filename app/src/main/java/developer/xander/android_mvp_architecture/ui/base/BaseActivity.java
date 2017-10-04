package developer.xander.android_mvp_architecture.ui.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import developer.xander.android_mvp_architecture.utilities.CommonUtils;
import developer.xander.android_mvp_architecture.utilities.NetworkHelper;
import developer.xander.android_mvp_architecture.utilities.SnackType;
import developer.xander.android_mvp_architecture.utilities.ViewUtils;


/**
 * Created by tony on 26/2/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ProgressBar progressBar;

    protected boolean isValidEmail(CharSequence target) {
        return CommonUtils.getUtils().isValidEmail(target);
    }

    public void showSnackBar(String msg, SnackType snackType){ //showing snackbar
        ViewUtils.getInstance().showSnackBar(msg, snackType, findViewById(android.R.id.content));
    }

    public void showToast(String msg) {
        ViewUtils.getInstance().showToast(this, msg);
    }

    protected boolean isNetworkAvailable() { // check network availability
        return NetworkHelper.getInstance().isNetworkAvailable();
    }

    protected void shareData(String data, String subject) {
        CommonUtils.getUtils().shareData(this, data, subject);
    }

    protected void openWebPage(String data) {
        CommonUtils.getUtils().openWebPage(this, data);
    }

    protected void openDialpad(String number) {
        CommonUtils.getUtils().openDialPad(this, number);
    }

    protected void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgressBar() {
        if (progressBar != null)
        progressBar.setVisibility(View.GONE);
    }

}
