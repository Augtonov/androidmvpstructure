package developer.xander.android_mvp_architecture.ui.base;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import developer.xander.android_mvp_architecture.utilities.CommonUtils;
import developer.xander.android_mvp_architecture.utilities.NetworkHelper;
import developer.xander.android_mvp_architecture.utilities.SnackType;
import developer.xander.android_mvp_architecture.utilities.ViewUtils;


/**
 * Created by tony on 26/2/16.
 */
public abstract class BaseFragment extends Fragment {

    private View view;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(createView(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewCreated();
        viewCreated(view);
    }

    protected void showSnackBar(String msg, SnackType snackType){
        if (getActivity() != null)
            ViewUtils.getInstance().showSnackBar(msg, snackType, getActivity().findViewById(android.R.id.content));
    }

    public void showToast(String msg) {
        if (getActivity() != null)
        ViewUtils.getInstance().showToast(getActivity(), msg);
    }

    protected boolean isNetworkAvailable() {
        return getActivity() != null && NetworkHelper.getInstance().isNetworkAvailable();
    }

    protected boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private void setProgressbar() {
        if (view != null && getProgressbar() != null && progressBar == null) {
            progressBar = (ProgressBar) view.findViewById(getProgressbar());
        }
    }

    protected void showProgressBar() {
        setProgressbar();
        if (progressBar.getVisibility() == View.GONE)
            progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgressBar() {
        setProgressbar();
        if (progressBar.getVisibility() == View.VISIBLE)
        progressBar.setVisibility(View.GONE);
    }

    protected void shareData(String data, String subject) {
        if (getActivity() != null)
        CommonUtils.getUtils().shareData(getActivity(), data, subject);
    }

    protected void openWebPage(String data) {
        if (getActivity() != null)
        CommonUtils.getUtils().openWebPage(getActivity(), data);
    }

    protected void openDialpad(String number) {
        if (getActivity() != null)
        CommonUtils.getUtils().openDialPad(getActivity(), number);
    }

    protected  abstract
    @LayoutRes
    int createView();

    protected abstract void viewCreated();

    protected abstract void viewCreated(View view);

    protected abstract Integer getProgressbar();

}
