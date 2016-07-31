package hackathon.hub.telmex.supermoon.common;

import android.content.Context;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public interface BaseView<T> {

  void setPresenter(T presenter);

  Context getContext();
}
