package hackathon.hub.telmex.supermoon.home.view.presenter;

import hackathon.hub.telmex.supermoon.home.domain.model.Place;
import hackathon.hub.telmex.supermoon.home.view.contract.PlaceContract;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ángel Gladín
 * @since 31/07/16
 */
public class PlacePresenter implements PlaceContract.Presenter {

  PlaceContract.View view;

  public PlacePresenter(PlaceContract.View view) {
    this.view = view;
  }

  @Override public void start() {
    view.showPlaceList(generateList());
  }

  List<Place> generateList() {
    List<Place> placeList = new ArrayList<>();
    placeList.add(new Place("Centro Historico",
        "El Centro Histórico de la Ciudad de México (o simplemente Centro Histórico o Centro, coloq"
            + "uialmente el Centro) constituye el núcleo original en torno al cual creció la actual c"
            + "apital mexicana.\nEl área de esta zona de la ciudad se puede definir de acuerdo "
            + "con dos criterios. En un sentido administrativo, corresponde a la colonia Centro de "
            + "la delegación Cuauhtémoc. En otro sentido, corresponde a la zona de monumentos históricos "
            + "delimitada por el Instituto Nacional de Antropología e Historia. Se reconcilió y circunscribió "
            + "por decreto presidencial el 11 de abril de 1980. Cuenta con un área cercana a 10 kilómetros cuadrados, "
            + "incluye y rebasa en parte el de la isla sobre la cual se fundó la ciudad prehispánica y también "
            + "el que tuvo luego la traza colonial. Es ahí, precisamente, donde perduran, a pesar de la acción"
            + " destructiva del tiempo y de los hombres, vestigios y monumentos extraordinarios que hablan"
            + " de los ya casi 7 siglos de la vida de la ciudad.",
        "http://www.mexicowanderer.com/wp-content/uploads/2013/05/Palace-of-Fine-Arts-Mexico-City-%C2%A9asmythie.jpg",
        19.4336523, -99.1454531));
    placeList.add(new Place("Museo Interactivo de Economía", "El MIDE, Museo "
        + "Interactivo de Economía, situado en la calle de Tacuba en el Centro Histórico de la Ciudad "
        + "de México, es un museo dedicado a la economía, las finanzas y el desarrollo sustentable."
        + " Está ubicado en el Antiguo Convento de Betlemitas. Abrió sus puertas en julio del 2006 y"
        + " fue creado por el Banco de México y diversas instituciones financieras privadas. Depende"
        + " del Fideicomiso del Espacio Cultural y Educativo Betlemitas y está regido por un Comité "
        + "Técnico que se reúne anualmente.",
        "http://sic.conaculta.gob.mx/galeria_imagen/4fc3b41755504fachada_017_OK_ok.jpg", 19.4354479,
        -99.1406115));
    return placeList;
  }

  @Override public void stop() {

  }

  @Override
  public void startEventActivity(String tittle, String description, String image, double latitude,
      double longitude) {

  }
}
