package hackathon.hub.telmex.supermoon.home.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import hackathon.hub.telmex.supermoon.R;
import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import hackathon.hub.telmex.supermoon.home.view.contract.PlaceContract;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 31/07/16
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PictureHolder> {

  private Context mContext;
  private LayoutInflater inflater;

  private List<Place> mList;

  private PlaceContract.Presenter mPresenter;

  public PlaceAdapter(Context context, PlaceContract.Presenter mPresenter) {
    this.mContext = context;
    this.inflater = LayoutInflater.from(mContext);
    this.mList = new ArrayList<>();
    this.mPresenter = mPresenter;
  }

  public void setAll(List<Place> l) {
    mList = l;
    notifyDataSetChanged();
  }

  @Override public PlaceAdapter.PictureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = inflater.inflate(R.layout.item_place, parent, false);
    return new PlaceAdapter.PictureHolder(viewItem, mPresenter);
  }

  @Override public void onBindViewHolder(PlaceAdapter.PictureHolder holder, int position) {
    holder.render(mList.get(position));
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  public static class PictureHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener {
    @BindView(R.id.label_tittle_place) TextView mLabelTittle;
    @BindView(R.id.label_place_description) TextView mLabelDescription;
    @BindView(R.id.image_place) ImageView mImagePlace;

    private PlaceContract.Presenter mPresenter;
    private Place pla;

    public PictureHolder(View itemView, PlaceContract.Presenter mPresenter) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
      this.mPresenter = mPresenter;
    }

    @Override public void onClick(View view) {
      mPresenter.startEventActivity(pla.getTittle(), pla.getDescription(), pla.getImage(),
          pla.getLatitude(), pla.getLongitude());
    }

    void render(Place pla) {
      this.pla = pla;
      mLabelTittle.setText(pla.getTittle());
      Glide.with(mImagePlace.getContext()).load(pla.getImage()).centerCrop().into(mImagePlace);
      mLabelDescription.setText(pla.getDescription());
    }
  }
}
