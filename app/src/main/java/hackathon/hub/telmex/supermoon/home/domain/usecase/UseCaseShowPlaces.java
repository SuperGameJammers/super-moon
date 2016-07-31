package hackathon.hub.telmex.supermoon.home.domain.usecase;

import hackathon.hub.telmex.supermoon.home.domain.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public class UseCaseShowPlaces {
  Subscription subscription = Subscriptions.empty();

  public void executeGetDestinations(Subscriber<List<Event>> useCaseSubscriber) {
    this.subscription = buildObservableUseCaseGetDestinations().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(useCaseSubscriber);
  }

  public void unSubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  Observable<List<Event>> buildObservableUseCaseGetDestinations() {
    return Observable.create((Observable.OnSubscribe<List<Event>>) subscriber -> {
      List<Event> eventList = new ArrayList<>();
      eventList.add(new Event("Museo", "http://svcdn.simpleviewinc.com/v3/cache/chicago/334C81AC039A9866849B2FA34D3F5F2C.jpg"));
      eventList.add(new Event("Concierto", "http://cdn.mxcity.mx/wp-content/uploads/2015/12/julio-20151.jpg"));
      eventList.add(new Event("Especiales", "http://masaryk.tv/wp-content/uploads/2015/01/mickeys-magic-show.jpg"));
      eventList.add(new Event("Talleres", "http://www.unitek.com/training/blog/images/it-blog.jpg"));
      eventList.add(new Event("Teatro", "http://www.garuyo.com/web/media/images/images/47'.jpg"));
      subscriber.onNext(eventList);
      subscriber.onCompleted();
    }).delay(1, TimeUnit.SECONDS);
  }
}
