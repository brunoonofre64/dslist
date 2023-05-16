package io.github.brunoonofre64.dslist.infrastructure.jpa.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
}
