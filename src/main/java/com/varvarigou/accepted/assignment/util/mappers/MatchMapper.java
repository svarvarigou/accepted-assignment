package com.varvarigou.accepted.assignment.util.mappers;

import com.varvarigou.accepted.assignment.models.dto.MatchDTO;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.util.DateUtils;

public class MatchMapper {

    public Match toMatch (MatchDTO matchDTO) {
        if (matchDTO == null){
            return  null;
        } else {
            return new Match(
                    matchDTO.getId(),
                    matchDTO.getDescription(),
                    matchDTO.getMatch_date(),
                    DateUtils.convertToDate(matchDTO.getMatch_time()),
                    matchDTO.getTeam_a(),
                    matchDTO.getTeam_b(),
                    matchDTO.getSport()
                    );
        }
    }
}
