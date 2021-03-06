package com.varvarigou.accepted.assignment;

import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.repositories.MatchRepository;
import com.varvarigou.accepted.assignment.services.MatchService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@SpringBootTest
@ContextConfiguration
public class MatchTests {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    MatchService matchService;

    private static Match dummyMatch;


    @BeforeAll
    public static void init() {
        dummyMatch = new Match();
        dummyMatch.setSportsValue(SportsEnum.FOOTBALL);
        dummyMatch.setMatch_date(new Date());
        dummyMatch.setMatch_time(new Date());
        dummyMatch.setDescription("This is a dummy test match");
        dummyMatch.setTeam_a("AEK");
        dummyMatch.setTeam_b("PAO");
    }

    @Test
    public void saveMatch(){
        Match savedMatch = matchService.saveMatch(dummyMatch);
       Assert.assertEquals(savedMatch,dummyMatch);
    }

    @Test
    public void updateMatch(){
        Iterable<Match> savedMatches = matchService.getAllMatches(null);
        for (Match savedMatch: savedMatches) {
            if(savedMatch.getSport().equals(SportsEnum.FOOTBALL)){
                savedMatch.setSportsValue(SportsEnum.BASKETBALL);
                matchService.saveMatch(savedMatch);
                Assert.assertEquals(matchService.getMatch(savedMatch.getId()).get().getSport(),SportsEnum.BASKETBALL);
                break;
            }
        }

    }


}
