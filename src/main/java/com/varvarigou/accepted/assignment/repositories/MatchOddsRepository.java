package com.varvarigou.accepted.assignment.repositories;

import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;
import org.springframework.data.repository.CrudRepository;

public interface MatchOddsRepository extends CrudRepository<MatchOdds,Long> {

    Iterable<MatchOdds> findMatchOddsByMatch(Match match);
}
