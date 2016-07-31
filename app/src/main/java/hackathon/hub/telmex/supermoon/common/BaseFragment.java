package hackathon.hub.telmex.supermoon.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public abstract class BaseFragment extends Fragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(getFragmentLayout(), container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    bindViews(view);
    initView(view, savedInstanceState);
  }

  protected void initView(View view, Bundle savedInstanceState) {
  }

  private void bindViews(View rootView) {
    ButterKnife.bind(this, rootView);
  }

  public void setResultAactivity(int resultCode, Intent data) {
    getActivity().setResult(resultCode, data);
  }

  public void finishActivity() {
    getActivity().finish();
  }

  public FragmentManager getActivitySupportFragmentManager() {
    return getActivity().getSupportFragmentManager();
  }

  public ActionBar getSupportActionBar() {
    return ((BaseActivity) getActivity()).getSupportActionBar();
  }

  public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit,
      @AnimRes int popEnter, @AnimRes int popExit) {
    ((BaseFragmentActivity) getActivity()).addFragment(fragment, enter, exit, popEnter, popExit);
  }

  public void replaceFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit) {
    ((BaseFragmentActivity) getActivity()).replaceFragment(fragment, enter, exit);
  }

  @Nullable public Toolbar getToolbar() {
    return ((BaseActivity) getActivity()).getToolbar();
  }

  protected abstract int getFragmentLayout();

  protected void showSnackBarMessage(String text) {
    Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
  }
}
