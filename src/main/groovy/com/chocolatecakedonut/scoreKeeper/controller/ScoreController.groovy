package com.chocolatecakedonut.scoreKeeper.controller

import com.chocolatecakedonut.scoreKeeper.service.ScoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ScoreController {
    @Autowired
    ScoreService scoreService

    @GetMapping("/scores")
    def getAllScores(){
        scoreService.getAllScores()
    }

    @GetMapping("/scores/{player}")
    def getScoresByPlayer(@PathVariable("player") String player){
        scoreService.getScoresBy(player)
    }

    @PostMapping("/scores")
    def saveScore(@RequestBody String json){
        scoreService.saveScore(json)
    }

}
