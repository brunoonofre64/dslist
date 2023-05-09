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
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String plataform;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
}
