package com.varvarigou.accepted.assignment.web;

import com.varvarigou.accepted.assignment.enums.SportsEnum;
import com.varvarigou.accepted.assignment.models.dto.MatchDTO;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.services.MatchService;
import com.varvarigou.accepted.assignment.util.mappers.MatchMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.collections4.IterableUtils;

import java.util.Optional;

@RestController
@Slf4j
public class MatchWeb {

    final
    MatchService matchService;

    @Autowired
    public MatchWeb(MatchService matchService) {
        this.matchService = matchService;
    }


    @GetMapping({"match/{id}","match"})
    public ResponseEntity<?> getMatch(@PathVariable(required = false) Long id, @RequestParam(required = false) SportsEnum sport){

        if(id != null){
            log.debug("quering match with id : ",id);
            Optional<Match> matchOptional = matchService.getMatch(id);

            if(matchOptional.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(matchOptional.get(),HttpStatus.OK);
            }
        } else {
            Iterable<Match> matches = matchService.getAllMatches(sport);
            if(IterableUtils.isEmpty(matches)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(matches,HttpStatus.OK);
            }
        }

    }

    @PostMapping("match")
    public ResponseEntity<Void> insertMatch(@RequestBody MatchDTO matchDTO){
        log.debug("received DTO ",matchDTO);
        Match match;
        MatchMapper matchMapper = new MatchMapper();
        try {
            match = matchMapper.toMatch(matchDTO);
            matchService.saveMatch(match);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("match")
    public ResponseEntity<Void> updateMatch(@RequestBody MatchDTO matchDTO){
        log.debug("received DTO ",matchDTO);
        Match match;
        MatchMapper matchMapper = new MatchMapper();
        try {
            match = matchMapper.toMatch(matchDTO);
            if(matchDTO.getId()==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!matchService.exists(match)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            matchService.saveMatch(match);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("match/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable(required = false) Long id){
        log.debug("deleted DTO wth id :",id);

        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
