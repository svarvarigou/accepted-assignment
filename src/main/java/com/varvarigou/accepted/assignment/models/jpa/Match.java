package com.varvarigou.accepted.assignment.models.jpa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.varvarigou.accepted.assignment.enums.SportsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Table(name = "match",
        indexes = {
                @Index(name = "IDX_MATCH_ID", columnList = "id"),
                @Index(name = "IDX_DATE", columnList = "match_date"),
                @Index(name = "IDX_TEAMS", columnList = "team_a, team_b"),
                @Index(name = "IDX_TEAMS_A", columnList = "team_a"),
                @Index(name = "IDX_TEAMS_B", columnList = "team_b")
        }
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Match implements Serializable {

    public Match(Long id, String description, Date match_date, Date match_time, String team_a, String team_b, SportsEnum sportsValue) {
        this.id = id;
        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sportsValue = sportsValue;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false)
    @Lob
    private String description;

    @Column(name = "match_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date match_date;

    @Column(name = "match_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date match_time;

    @Column(name="team_a", nullable = false)
    private String team_a;


    @Column(name="team_b", nullable = false)
    private String team_b;

    @JsonIgnore
    @Column(name = "sport", nullable = false)
    private Integer sport;

    @Transient
    private SportsEnum sportsValue;

    @PrePersist
    void fillPersistent() {
        if (sportsValue != null) {
            this.sport = sportsValue.getType();
        }
    }

    @PostLoad
    void fillTransient() {
        if (sport > 0) {
            this.sportsValue = SportsEnum.valueOfLabel(sport);
        }
    }


    @JsonIgnore
    @OneToMany(mappedBy = "match", cascade = CascadeType.REMOVE)
    private Set<MatchOdds> matchOdds;

    //testing something

}
