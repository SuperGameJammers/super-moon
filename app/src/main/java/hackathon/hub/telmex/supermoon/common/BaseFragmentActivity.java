package hackathon.hub.telmex.supermoon.common;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public abstract class BaseFragmentActivity extends BaseActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeFragment();
  }

  protected abstract Fragment getFragmentInstance();

  protected abstract int getIdFragmentContainer();

  private void initializeFragment() {
    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentById(getIdFragmentContainer());
    if (fragment == null) {
      fm.beginTransaction().add(getIdFragmentContainer(), getFragmentInstance()).commit();
    }
  }

  public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit,
      @AnimRes int popEnter, @AnimRes int popExit) {
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(enter, exit, popEnter, popExit)
        .replace(getIdFragmentContainer(), fragment)
        .addToBackStack("")
        .commit();
  }

  public void replaceFragment(final Fragment fragment, @AnimRes int enter, @AnimRes int exit) {
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(enter, exit)
        .replace(getIdFragmentContainer(), fragment)
        .commit();
  }

  public void popFragment() {
    getSupportFragmentManager().popBackStackImmediate();
  }
}
