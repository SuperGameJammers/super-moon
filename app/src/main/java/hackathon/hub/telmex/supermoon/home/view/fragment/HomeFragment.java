package hackathon.hub.telmex.supermoon.home.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import hackathon.hub.telmex.supermoon.R;
import hackathon.hub.telmex.supermoon.common.BaseFragment;
import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import hackathon.hub.telmex.supermoon.home.view.adapter.PlaceAdapter;
import hackathon.hub.telmex.supermoon.home.view.contract.HomeContract;
import hackathon.hub.telmex.supermoon.home.view.presenter.HomePresenter;
import hackathon.hub.telmex.supermoon.home.widget.ItemOffsetDecoration;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public class HomeFragment extends BaseFragment implements HomeContract.View {

  @BindView(R.id.progress_home) ProgressBar mProgressBar;
  @BindView(R.id.list_events) RecyclerView mList;
  HomeContract.Presenter mPresenter;

  PlaceAdapter mAdapter;

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override protected void initView(View view, Bundle savedInstanceState) {
    initializePresenter();
  }

  private void initializePresenter() {
    mPresenter = new HomePresenter(this);
    mPresenter.start();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    mPresenter.stop();
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_home;
  }

  @Override public void showLoading() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    mProgressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void showEventsList(List<Place> l) {
    mAdapter = new PlaceAdapter(getContext(), mPresenter);
    mList.setAdapter(mAdapter);
    mList.setLayoutManager(getGridLayoutManager());
    //mList.addItemDecoration(new ItemOffsetDecoration(mList.getContext(), R.dimen.item_decoration));
    mList.setItemAnimator(new DefaultItemAnimator());
    mAdapter.setAll(l);
  }

  private GridLayoutManager getGridLayoutManager() {
    GridLayoutManager gridLayoutManager =
        new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
      @Override public int getSpanSize(int position) {
        return (position % 3 == 0 ? 2 : 1);
      }
    });
    return gridLayoutManager;
  }

  @Override public void startEventActivity(String tittle, String image) {
    //showDefaultMessageSnackBar("asdlkasdklj");
  }
}
