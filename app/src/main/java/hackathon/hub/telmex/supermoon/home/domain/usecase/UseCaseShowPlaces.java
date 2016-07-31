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
      final String URL =
          "https://material-design.storage.googleapis.com/publish/material_v_8/material_ext_publish/0Bx4BSt6jniD7dkRYelJkeklqWFU/materialdesign_principles_motion.png";
      List<Place> placeList = new ArrayList<>();
      placeList.add(new Place("Museo", URL));
      placeList.add(new Place("Concierto", URL));
      placeList.add(new Place("Especiales", URL));
      placeList.add(new Place("Talleres", URL));
      placeList.add(new Place("Teatro", URL));
      subscriber.onNext(placeList);
      subscriber.onCompleted();
    }).delay(1, TimeUnit.SECONDS);
  }
}
