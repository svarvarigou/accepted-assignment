package com.varvarigou.accepted.assignment.services;

import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;
import com.varvarigou.accepted.assignment.repositories.MatchOddsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class MatchOddsService {

    final MatchOddsRepository matchOddsRepository;

    @Autowired
    public MatchOddsService(MatchOddsRepository matchOddsRepo) {
        matchOddsRepository = matchOddsRepo;
    }

    public MatchOdds saveMatchOdds(MatchOdds matchOdds){
        return matchOddsRepository.save(matchOdds);
    }

    public void deleteMatchOdds(Long id) {
        matchOddsRepository.deleteById(id);
    }

    public Optional<MatchOdds> getMatchOdds(Long id) {
        return matchOddsRepository.findById(id);
    }

    public Iterable<MatchOdds> getAllMatchOdds(){
        return matchOddsRepository.findAll();
    }

    public Iterable<MatchOdds> getMatchOddsByMatch(Match match){
        return matchOddsRepository.findMatchOddsByMatch(match);
    }

    public Boolean exists(Long id){
        return matchOddsRepository.existsById(id);
    }
}
