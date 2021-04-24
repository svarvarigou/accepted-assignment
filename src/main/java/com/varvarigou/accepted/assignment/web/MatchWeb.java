package com.varvarigou.accepted.assignment.web;

import com.varvarigou.accepted.assignment.models.web.Foo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MatchWeb {


    @GetMapping("hello")
    public ResponseEntity<Foo> check(@RequestParam(required = false) String foo){

        Foo fooModel = new Foo("Stella","Varvarigou");

        if(foo == null){
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            return new ResponseEntity<>(fooModel,HttpStatus.OK);
        }


    }


}
