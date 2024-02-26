package global.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Tripspot implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String nation;
  private String region;
  private String description;
  private int rating;
  private Date createdDate;
  
  @Override
  public String toString() {
    return "Tripspot{" +
        "no=" + no +
        ", nation='" + nation + '\'' +
        ", region='" + region + '\'' +
        ", description='" + description + '\'' +
        ", rating='" + rating +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
