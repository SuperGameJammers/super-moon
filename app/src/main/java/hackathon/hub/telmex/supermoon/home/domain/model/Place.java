package hackathon.hub.telmex.supermoon.home.domain.model;

/**
 * @author Ángel Gladín
 * @since 31/07/16
 */
public class Place {
  String tittle;
  String description;
  String image;
  double longitude;
  double latitude;

  public Place(String tittle, String description, String image, double longitude, double latitude) {
    this.tittle = tittle;
    this.description = description;
    this.image = image;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public String getTittle() {
    return tittle;
  }

  public String getDescription() {
    return description;
  }

  public String getImage() {
    return image;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }
}
