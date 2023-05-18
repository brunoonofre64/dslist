package io.github.brunoonofre64.dslist.infrastructure.jpa.projections;

public interface GameMinProjection {
    String getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
}
