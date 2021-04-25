package com.varvarigou.accepted.assignment.repositories;


import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Long> {

    Iterable<Match> findBySport(SportsEnum sportsEnum);
}
