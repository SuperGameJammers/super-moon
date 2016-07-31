package hackathon.hub.telmex.supermoon.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import hackathon.hub.telmex.supermoon.R;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public abstract class BaseActivity extends AppCompatActivity {
  @BindView(R.id.toolbar) Toolbar mToolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(setLayout());
    bindViews();
    setupToolbar();
  }


  protected void setupToolbar() {
      setSupportActionBar(mToolbar);
  }

  private void bindViews() {
    ButterKnife.bind(this);
  }

  @Nullable public Toolbar getToolbar() {
    return mToolbar;
  }

  protected abstract int setLayout();
}
