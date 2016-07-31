package hackathon.hub.telmex.supermoon.home.view.presenter;

import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import hackathon.hub.telmex.supermoon.home.domain.usecase.UseCaseShowPlaces;
import hackathon.hub.telmex.supermoon.home.view.contract.HomeContract;
import java.util.List;
import rx.Subscriber;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public class HomePresenter implements HomeContract.Presenter {
  UseCaseShowPlaces mUseCase;

  HomeContract.View view;

  public HomePresenter(HomeContract.View view) {
    this.view = view;
    this.mUseCase = new UseCaseShowPlaces();
  }

  @Override public void startEventActivity(String tittle, String image) {
    view.startEventActivity(tittle, image);
  }

  @Override public void start() {
    view.showLoading();

    mUseCase.executeGetDestinations(new Subscriber<List<Place>>() {
      @Override public void onCompleted() {
        view.hideLoading();
      }

      @Override public void onError(Throwable e) {
      }

      @Override public void onNext(List<Place> places) {
        view.showEventsList(places);
      }
    });
  }

  @Override public void stop() {
    mUseCase.unSubscribe();
  }
}
