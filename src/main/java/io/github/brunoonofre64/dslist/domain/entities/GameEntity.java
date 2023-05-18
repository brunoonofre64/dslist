package io.github.brunoonofre64.dslist.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String title;
    private Double score;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;


    @PrePersist
    private void prePersis() {
        this.id = UUID.randomUUID().toString();
    }
}
