package hackathon.hub.telmex.supermoon.home.domain.model;

/**
 * @author Ángel Gladín
 * @since 30/07/16
 */
public class Event {
  String tittle;
  String imagePath;

  public Event(String tittle, String imagePath) {
    this.tittle = tittle;
    this.imagePath = imagePath;
  }

  public String getTittle() {
    return tittle;
  }

  public String getImagePath() {
    return imagePath;
  }
}
