package com.varvarigou.accepted.assignment.models.jpa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Table(name = "match",
        indexes = {
                @Index(name = "IDX_MATCH_ID", columnList = "id"),
                @Index(name = "IDX_DATE", columnList = "match_date"),
                @Index(name = "IDX_TEAMS", columnList = "team_a, team_b"),
                @Index(name = "IDX_TEAMS_B", columnList = "team_b, team_a")
        }
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Match implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "match_date")
    @Temporal(TemporalType.DATE)
    private Date match_date;

    @Column(name = "match_time")
    @Temporal(TemporalType.TIME)
    private Date match_time;

    @Column(name="team_a", length=50)
    private String team_a;


    @Column(name="team_b", length=50)
    private String team_b;

    @Column(name = "sport")
    @Enumerated(EnumType.ORDINAL)
    private Sports sport;

    @JsonIgnore
    @OneToMany(mappedBy = "match")
    private Set<MatchOdds> matchOdds;
}
