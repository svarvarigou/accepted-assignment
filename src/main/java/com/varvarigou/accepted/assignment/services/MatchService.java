package com.varvarigou.accepted.assignment.services;

import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.repositories.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class MatchService {

    final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Transactional
    public Match saveMatch(Match match){
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id){
        matchRepository.deleteById(id);
    }

    public Optional<Match> getMatch(Long id){
        return matchRepository.findById(id);
    }

    public Iterable<Match> getAllMatches(SportsEnum sportsEnum){
        if(sportsEnum == null) {
            return matchRepository.findAll();
        }
        return getMatchesBySport(sportsEnum);
    }

    public Boolean exists(Match match){
        return matchRepository.existsById(match.getId());
    }

    public Iterable<Match> getMatchesBySport(SportsEnum sportsEnum){
        return matchRepository.findBySport(sportsEnum);
    }


}
