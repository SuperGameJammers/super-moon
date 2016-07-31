package hackathon.hub.telmex.supermoon.home.view.contract;

import hackathon.hub.telmex.supermoon.common.BasePresenter;
import hackathon.hub.telmex.supermoon.common.BaseView;
import hackathon.hub.telmex.supermoon.home.domain.model.Event;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public interface EventContract {
  interface View extends BaseView<Presenter> {

    void showLoading();

    void hideLoading();

    void showEventsList(List<Event> l);

    void startEventActivity(String tittle, String image);
  }

  interface Presenter extends BasePresenter {
    void startEventActivity(String tittle, String image);
  }
}
