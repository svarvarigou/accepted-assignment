package com.varvarigou.accepted.assignment.web;

import com.varvarigou.accepted.assignment.models.dto.MatchOddsDTO;
import com.varvarigou.accepted.assignment.models.jpa.Match;
import com.varvarigou.accepted.assignment.models.jpa.MatchOdds;
import com.varvarigou.accepted.assignment.services.MatchOddsService;
import com.varvarigou.accepted.assignment.services.MatchService;
import com.varvarigou.accepted.assignment.util.mappers.MatchOddsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class MatchOddsWeb {

    final MatchService matchService;
    final MatchOddsService matchOddsService;

    @Autowired
    public MatchOddsWeb(MatchService matchService, MatchOddsService matchOddsService){
        this.matchService = matchService;
        this.matchOddsService = matchOddsService;
    }

    @PostMapping("matchOdds")
    public ResponseEntity<Void> insertMatchOdds(@RequestBody MatchOddsDTO matchOddsDTO){
        log.debug("received DTO {}",matchOddsDTO);
        MatchOdds matchOdds;
        MatchOddsMapper matchOddsMapper = new MatchOddsMapper();
        try {
            matchOdds = matchOddsMapper.toMatchOdds(matchOddsDTO);

            Optional<Match> match = matchService.getMatch(matchOddsDTO.getMatch_id());
            if(!match.isPresent()){
                log.info("The match id {} was not found",matchOddsDTO.getMatch_id());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            matchOdds.setMatch(match.get());
            matchOddsService.saveMatchOdds(matchOdds);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"matchOdds/{matchId}","matchOdds"})
    public ResponseEntity<Iterable<MatchOdds>> getMatchOdds(@PathVariable(required = false) Long matchId){
      if(matchId == null) {
            return new ResponseEntity<>(matchOddsService.getAllMatchOdds(),HttpStatus.OK);
        } else {
            log.debug("quering matchOdds with matchId : {}",matchId);
            Optional<Match> matchOptional = matchService.getMatch(matchId);
            if(matchOptional.isPresent()){
                return new ResponseEntity<>(matchOddsService.getMatchOddsByMatch(matchOptional.get()),HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    }

    @PutMapping("matchOdds")
    public ResponseEntity<Void> updateMatchOdds(@RequestBody MatchOddsDTO matchOddsDTO){
        log.debug("received DTO {}",matchOddsDTO);

        MatchOdds matchOdds;
        MatchOddsMapper matchOddsMapper = new MatchOddsMapper();
        try {
            if(matchOddsDTO.getId()==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!matchOddsService.exists(matchOddsDTO.getId())){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            if(!matchService.exists(matchOddsDTO.getMatch_id())){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            matchOdds = matchOddsMapper.toMatchOdds(matchOddsDTO);
            Optional<Match> match = matchService.getMatch(matchOddsDTO.getMatch_id());
            if(!match.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            matchOdds.setMatch(match.get());
            matchOddsService.saveMatchOdds(matchOdds);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("matchOdds/{id}")
    public ResponseEntity<Void> deleteMatchOdds(@PathVariable(required = false) Long id){
        log.debug("deleted DTO wth id :{}",id);

        try {
            matchOddsService.deleteMatchOdds(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
