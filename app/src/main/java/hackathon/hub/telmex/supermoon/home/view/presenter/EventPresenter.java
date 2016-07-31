package hackathon.hub.telmex.supermoon.home.view.presenter;

import hackathon.hub.telmex.supermoon.home.domain.model.Event;
import hackathon.hub.telmex.supermoon.home.domain.usecase.UseCaseShowPlaces;
import hackathon.hub.telmex.supermoon.home.view.contract.EventContract;
import java.util.List;
import rx.Subscriber;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public class EventPresenter implements EventContract.Presenter {
  UseCaseShowPlaces mUseCase;

  EventContract.View view;

  public EventPresenter(EventContract.View view) {
    this.view = view;
    this.mUseCase = new UseCaseShowPlaces();
  }

  @Override public void startEventActivity(String tittle, String image) {
    view.startEventActivity(tittle, image);
  }

  @Override public void start() {
    view.showLoading();

    mUseCase.executeGetDestinations(new Subscriber<List<Event>>() {
      @Override public void onCompleted() {
        view.hideLoading();
      }

      @Override public void onError(Throwable e) {
      }

      @Override public void onNext(List<Event> events) {
        view.showEventsList(events);
      }
    });
  }

  @Override public void stop() {
    mUseCase.unSubscribe();
  }
}
