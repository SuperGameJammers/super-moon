package hackathon.hub.telmex.supermoon.home.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import hackathon.hub.telmex.supermoon.R;
import hackathon.hub.telmex.supermoon.common.BaseFragmentActivity;
import hackathon.hub.telmex.supermoon.home.view.fragment.EventFragment;

public class EventActivity extends BaseFragmentActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected Fragment getFragmentInstance() {
    return EventFragment.newInstance();
  }

  @Override protected int getIdFragmentContainer() {
    return R.id.fragment_container;
  }

  @Override protected int setLayout() {
    return R.layout.activity_home;
  }
}
