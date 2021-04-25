package com.varvarigou.accepted.assignment.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO implements Serializable {

    private Long id;
    private String description;
    private Date match_date;
    private LocalTime match_time;
    private String team_a;
    private String team_b;
    private SportsEnum sport;
    @JsonIgnore
    private MatchOdds matchOdds;
}
