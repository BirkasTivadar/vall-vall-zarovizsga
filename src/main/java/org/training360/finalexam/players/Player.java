package org.training360.finalexam.players;

import lombok.*;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_pos")
    private PositionType position;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team team;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Player(String name, PositionType position) {
        this.name = name;
        this.position = position;
    }

    public Player(String name, LocalDate dateOfBirth, PositionType position) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }


}
