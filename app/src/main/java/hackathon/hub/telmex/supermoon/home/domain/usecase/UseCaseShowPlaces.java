package hackathon.hub.telmex.supermoon.home.domain.usecase;

import hackathon.hub.telmex.supermoon.home.domain.model.Place;
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

  public void executeGetDestinations(Subscriber<List<Place>> useCaseSubscriber) {
    this.subscription = buildObservableUseCaseGetDestinations().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(useCaseSubscriber);
  }

  public void unSubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  Observable<List<Place>> buildObservableUseCaseGetDestinations() {
    return Observable.create((Observable.OnSubscribe<List<Place>>) subscriber -> {
      List<Place> placeList = new ArrayList<>();
      placeList.add(new Place("Museo", "http://svcdn.simpleviewinc.com/v3/cache/chicago/334C81AC039A9866849B2FA34D3F5F2C.jpg"));
      placeList.add(new Place("Concierto", "http://cdn.mxcity.mx/wp-content/uploads/2015/12/julio-20151.jpg"));
      placeList.add(new Place("Especiales", "http://masaryk.tv/wp-content/uploads/2015/01/mickeys-magic-show.jpg"));
      placeList.add(new Place("Talleres", "http://www.unitek.com/training/blog/images/it-blog.jpg"));
      placeList.add(new Place("Teatro", "http://www.garuyo.com/web/media/images/images/47'.jpg"));
      subscriber.onNext(placeList);
      subscriber.onCompleted();
    }).delay(1, TimeUnit.SECONDS);
  }
}
