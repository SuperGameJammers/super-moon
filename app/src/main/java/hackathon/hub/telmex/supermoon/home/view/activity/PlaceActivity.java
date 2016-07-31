package hackathon.hub.telmex.supermoon.home.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import hackathon.hub.telmex.supermoon.R;
import hackathon.hub.telmex.supermoon.common.BaseActivity;
import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import hackathon.hub.telmex.supermoon.home.view.adapter.EventAdapter;
import hackathon.hub.telmex.supermoon.home.view.adapter.PlaceAdapter;
import hackathon.hub.telmex.supermoon.home.view.contract.PlaceContract;
import hackathon.hub.telmex.supermoon.home.view.presenter.EventPresenter;
import hackathon.hub.telmex.supermoon.home.view.presenter.PlacePresenter;
import java.util.List;

public class PlaceActivity extends BaseActivity implements PlaceContract.View{

  @BindView(R.id.image_header) ImageView imageView;
  @BindView(R.id.toolbar_layout) CollapsingToolbarLayout collapsingToolbar;

  @BindView(R.id.list_category_event) RecyclerView mList;

  private PlaceAdapter mAdapter;
  private PlaceContract.Presenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    Glide.with(imageView.getContext())
        .load(getIntent().getStringExtra("image"))
        .centerCrop()
        .into(imageView);
    initializeList();

    mPresenter = new PlacePresenter(this);
    mPresenter.start();

  }

  private void initializeList() {
    mAdapter = new PlaceAdapter(getApplicationContext(), mPresenter);
    mList.setAdapter(mAdapter);
    mList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    mList.setItemAnimator(new DefaultItemAnimator());
  }

  @Override protected int setLayout() {
    return R.layout.activity_place;
  }

  @Override public void showPlaceList(List<Place> l) {

    mAdapter.setAll(l);

  }

  @Override
  public void startEventActivity(String tittle, String description, String image, double latitude,
      double longitude) {

  }

  @Override public Context getContext() {
    return null;
  }
}
