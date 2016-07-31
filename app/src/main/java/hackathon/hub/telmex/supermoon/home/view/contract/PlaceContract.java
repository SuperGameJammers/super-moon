package hackathon.hub.telmex.supermoon.home.view.contract;

import hackathon.hub.telmex.supermoon.common.BasePresenter;
import hackathon.hub.telmex.supermoon.common.BaseView;
import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 31/07/16
 */
public interface PlaceContract {
  interface View extends BaseView<Presenter> {

    void showPlaceList(List<Place> l);

    void startEventActivity(String tittle, String description, String image, double latitude, double longitude);
  }

  interface Presenter extends BasePresenter {
    void startEventActivity(String tittle, String description, String image, double latitude, double longitude);
  }
}
