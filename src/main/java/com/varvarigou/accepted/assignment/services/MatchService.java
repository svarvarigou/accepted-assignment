package com.varvarigou.accepted.assignment.services;

import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.repositories.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MatchService {

    final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match insertMatch(Match match){
        return matchRepository.save(match);
    }
}
