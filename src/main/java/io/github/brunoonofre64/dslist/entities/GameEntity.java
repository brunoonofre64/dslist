package io.github.brunoonofre64.dslist.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
