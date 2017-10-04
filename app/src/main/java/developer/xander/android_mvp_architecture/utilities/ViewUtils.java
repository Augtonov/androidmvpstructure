package developer.xander.android_mvp_architecture.utilities;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Augtonov on 1/10/17.
 */

public class ViewUtils {

    private static ViewUtils viewUtils;

    public static ViewUtils getInstance() {
        if (viewUtils == null) {
            viewUtils = new ViewUtils();
        }
        return viewUtils;
    }

    public void showSnackBar(String msg, SnackType snackType, View contentView){

        try {
            Snackbar snackbar = Snackbar.make(contentView, msg, Snackbar.LENGTH_SHORT);
            View view  = snackbar.getView();
            TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            if (snackType.equals(SnackType.SNACKTYPE_SUCCESS)){
                view.setBackgroundColor(Color.GRAY);
            }else if (snackType.equals(SnackType.SNACKTYPE_FAILED)){
                view.setBackgroundColor(Color.RED);
            }

            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
