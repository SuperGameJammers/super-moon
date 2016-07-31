package hackathon.hub.telmex.supermoon.home.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import hackathon.hub.telmex.supermoon.R;
import hackathon.hub.telmex.supermoon.home.domain.model.Event;
import hackathon.hub.telmex.supermoon.home.view.contract.EventContract;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 31/07/16
 */
public class EventAdapter extends RecyclerView.Adapter<> {

  private Context mContext;
  private LayoutInflater inflater;

  private List<Event> mList;

  private EventContract.Presenter mPresenter;

  public EventAdapter(Context context, EventContract.Presenter mPresenter) {
    this.mContext = context;
    this.inflater = LayoutInflater.from(mContext);
    this.mList = new ArrayList<>();
    this.mPresenter = mPresenter;
  }

  public void setAll(List<Event> l) {
    mList = l;
    notifyDataSetChanged();
  }

  @Override public onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = inflater.inflate(R.layout.item_event, parent, false);
    return new EventAdapter.PictureHolder(viewItem, mPresenter);
  }

  @Override public void onBindViewHolder(EventAdapter.PictureHolder holder, int position) {
    holder.render(mList.get(position));
  }

  @Override public int getItemCount() {
    return mList.size();
  }
}
