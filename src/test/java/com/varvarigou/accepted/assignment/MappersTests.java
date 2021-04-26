package com.varvarigou.accepted.assignment;

import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.dto.MatchDTO;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.util.mappers.MatchMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static com.varvarigou.accepted.assignment.util.DateUtils.convertToLocalTime;

@SpringBootTest
@ContextConfiguration
public class MappersTests {

    @Test
    public void toMatch(){
        MatchDTO dummyMatchDto;
        dummyMatchDto = new MatchDTO(
                null,
                "This is a match mapper test.",
                new Date(),
                convertToLocalTime(new Date()),
                "PAO",
                "AEK",
                SportsEnum.BASKETBALL,
                null
                );

        MatchMapper matchMapper = new MatchMapper();
        Match match = matchMapper.toMatch(dummyMatchDto);

        Boolean notEmpty;

        notEmpty = !match.getDescription().isEmpty()
                && match.getMatch_date() != null
                && match.getMatch_time() != null
                && !match.getTeam_a().isEmpty()
                && !match.getTeam_b().isEmpty();

        Assert.assertTrue(notEmpty);
    }


}
