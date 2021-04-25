package com.varvarigou.accepted.assignment.models.dto;

import com.varvarigou.accepted.assignment.enums.SpecifierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MatchOddsDTO implements Serializable {

    private Long id;
    private Long match_id;
    private SpecifierEnum specifier;
    private Double odd;
}
