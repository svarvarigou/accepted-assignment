package com.varvarigou.accepted.assignment.util.mappers;

import com.varvarigou.accepted.assignment.models.dto.MatchOddsDTO;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;

public class MatchOddsMapper {
    public MatchOdds toMatchOdds (MatchOddsDTO matchOddsDTO) {
        if (matchOddsDTO == null){
            return  null;
        } else {
            return new MatchOdds(
                    matchOddsDTO.getId(),
                    matchOddsDTO.getSpecifier(),
                    matchOddsDTO.getOdd()
            );
        }
    }
}
