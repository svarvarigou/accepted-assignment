package com.varvarigou.accepted.assignment;

import com.varvarigou.accepted.assignment.enums.SpecifierEnum;
import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;
import com.varvarigou.accepted.assignment.repositories.MatchOddsRepository;
import com.varvarigou.accepted.assignment.services.MatchOddsService;
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
public class MatchOddsTests {

    @Autowired
    MatchOddsRepository matchOddsRepository;

    @Autowired
    MatchService matchService;

    @Autowired
    MatchOddsService matchOddsService;

    private static MatchOdds dummyMatchOdds;
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

        dummyMatchOdds = new MatchOdds();
        dummyMatchOdds.setMatch(dummyMatch);
        dummyMatchOdds.setOdd(1.5);
        dummyMatchOdds.setSpecifier(SpecifierEnum.X);
    }

    @Test
    public void saveMatchOdds(){
        Match savedMatch = matchService.saveMatch(dummyMatch);

        MatchOdds savedMatchOdds = matchOddsService.saveMatchOdds(dummyMatchOdds);

        Assert.assertEquals(savedMatchOdds,dummyMatchOdds);

    }


}
