package com.varvarigou.accepted.assignment;

import com.varvarigou.accepted.assignment.enums.Sports;
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
        dummyMatch.setSport(Sports.FOOTBALL);
        dummyMatch.setMatch_date(new Date());
        dummyMatch.setMatch_time(new Date());
        dummyMatch.setDescription("This is a dummy test match");
    }

    @Test
    public void saveMatch(){
       Match savedMatch = matchService.insertMatch(dummyMatch);
       Assert.assertEquals(savedMatch,dummyMatch);
    }

}
