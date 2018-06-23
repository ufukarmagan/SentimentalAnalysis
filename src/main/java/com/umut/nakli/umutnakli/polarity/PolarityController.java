package com.umut.nakli.umutnakli.polarity;

import com.umut.nakli.umutnakli.submit.Submit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/polarity")
public class PolarityController {
    @Autowired
    PolarityService polarityService;

    @PostMapping
    String postSubmit(@RequestBody Submit submit){
        System.out.println(submit.getText());
        return polarityService.decidePolarity(submit);
    }
//    @RequestMapping("/smo")
//    void addSmoo(@RequestBody SMOWord smoWord){
//        polarityService.addSMOWord(smoWord);
//    }
}
